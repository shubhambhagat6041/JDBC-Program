package practicalTask;
import java.util.*;
import java.sql.*;
public class jdbcStudentPracticaltaskCase 
{
	public static void main(String x[])throws SQLException
	{
		Scanner xyz=new Scanner(System.in);
		int choice,value;
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root","root");
		Statement smt=conn.createStatement();
		
		System.out.println("1:Create table Name as Student");
		System.out.println("2:Insert 10 record in student table sid,sname,semail,scontact,saddress");
		System.out.println("3:Display all Record of Student tables");
		System.out.println("4:Write a Sql query to display only name,email,contact");
		System.out.println("5:Write sql query to display distinct name from student table");
		System.out.println("6:Write sql query delete student whose id is 1");
		System.out.println("7:Write sql query to delete student whose id is 4 and name is ram");
		System.out.println("8:Write sql query to update student whose id is 1 or name is shyam");
		System.out.println("9:Write  sql query to change name,email,and contact of Student whose id is 3");
		
		
		do
		{
			System.out.println("Enter the choice");
			choice=xyz.nextInt();
			switch(choice)
			{
				case 1:
					String q="create table student(sid int(10),sname varchar(200),semail varchar(200),scontact varchar(200),saddress varchar(200))";
					 value=smt.executeUpdate(q);
					if(value<1)
					{
						System.out.println("Table Created......");
					}
					else
					{
						System.out.println("Table not created.......");
					}
					break;
					
				case 2:
					System.out.println("Enter the Student id");
					int sid=xyz.nextInt();
					xyz.nextLine();
					System.out.println("Enter the Student Name");
					String sname=xyz.nextLine();
					System.out.println("Enter the Student email");
					String semail=xyz.nextLine();
					System.out.println("Enter the Student contact");
					String scontact=xyz.nextLine();
					System.out.println("Enter the Student Address");
					String saddress=xyz.nextLine();
					
					value=smt.executeUpdate("insert into student values("+sid+",'"+sname+"','"+semail+"','"+scontact+"','"+scontact+"')");
					if(value>0)
					{
						System.out.println("Record Save successfully..........");
					}
					else
					{
						System.out.println("Record not save...............problem........");
					}
					break;
					
				case 3:
					ResultSet rs=smt.executeQuery("select *from student");
					while(rs.next())
					{
						int id=rs.getInt("sid");
						String name=rs.getString("sname");
						String email=rs.getString("semail");
						String contact=rs.getString("scontact");
						String address=rs.getString("saddress");
						
						System.out.println(id+"\t"+name+"\t"+email+"\t"+contact+"\t"+address);
					}
					break;
					
				case 4:
					ResultSet rs1=smt.executeQuery("select sname,semail,scontact from student");
					while(rs1.next())
					{	
						String name=rs1.getString("sname");
						String email=rs1.getString("semail");
						String contact=rs1.getString("scontact");		
						
						System.out.println(name+"\t"+email+"\t"+contact);
					}
					break;
					
				case 5:
					ResultSet rs2=smt.executeQuery("select distinct sname from student");
					while(rs2.next())
					{
						String name=rs2.getString("sname");
						System.out.println(name);
					}
					break;
					
				case 6:
					value=smt.executeUpdate("delete from student where sid=1");
					if(value>0)
					{
						System.out.println("record deleted successfully........");
					}
					else
					{
						System.out.println("Record not deleted");
					}
					break;
					
				case 7:
					value=smt.executeUpdate("delete from student where sid=4 and sname='ram'");
					if(value>0)
					{
						System.out.println("record deleted successfully....");
					}
					else
					{
						System.out.println("Record not found.........");
					}
					break;
					
				case 8:
					value=smt.executeUpdate("update student set semail='s@gmail.com' where sid=1 and sname='shyam'");
					if(value>0)
					{
						System.out.println("Updated Successfully........");
					}
					else
					{
						System.out.println("problem here..........");
					}
					break;
					
				case 9:
					System.out.println("Enter the update name");
					String name=xyz.next();
					System.out.println("Enter the Email");
					String email=xyz.next();
					System.out.println("Enter the contact");
					String contact=xyz.next();
					value=smt.executeUpdate("update student set sname='"+name+"',semail='"+email+"',scontact='"+contact+"' where sid=3");
					if(value>0)
					{
						System.out.println("updated successfully..............");
					}
					else
					{
						System.out.println("not updated............................");
					}
					
					break;
					
					default:
						System.out.println("Wrong Choice");
			}
		}
		
		while(true);
	}
}
