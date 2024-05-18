package practicalTask;
import java.sql.*;
import java.util.*;
public class JdbcOpearation 
{
	public static void main(String x[])throws SQLException
	{
		Scanner xyz=new Scanner(System.in);
		int choice,value;
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		Statement smt=conn.createStatement();
		do
		{
			System.out.println("1Create Table Name as Employee");
			System.out.println("2:Insert five record of Employee table using field id,name,email,sal,contact");
			System.out.println("3:Display all Record of Employee table");
			System.out.println("4:Update Employee Record by id");
			System.out.println("5:Delete Employee Record by Name");
			System.out.println("Enter the Choice");
			choice=xyz.nextInt();
			switch(choice)
			{
				case 1:
					String q="create table employee(id int(5),name varchar(200),email varchar(200),sal int(10),contact varchar(200))";
					value=smt.executeUpdate(q);
					if(value<1)
					{
						System.out.println("table Created");
					}
					else
					{
						System.out.println("Table not created");
					}
					break;
				case 2:
					System.out.println("Enter the id of employee");
					int id=xyz.nextInt();
					xyz.nextLine();
					System.out.println("Enter the Name of Employee");
					String name=xyz.nextLine();
					System.out.println("Enter the email of Employe");
					String email=xyz.nextLine();
					System.out.println("Enter the Salary of Employee");
					int sal=xyz.nextInt();
					xyz.nextLine();
					System.out.println("Enter the Contact of Employee");
					String contact=xyz.nextLine();
					
					 value=smt.executeUpdate("insert into employee values("+id+",'"+name+"','"+email+"',"+sal+","+contact+")");
					if(value>0)
					{
						System.out.println("Record save Successfully.....");
					}
					else
					{
						System.out.println("Record not save.....");
					}
					break;
					
				case 3:
					ResultSet rs=smt.executeQuery("Select *from employee");
					while(rs.next())
					{
						int eid=rs.getInt("id");
						String ename=rs.getString("name");
						String eemail=rs.getString("email");
						int esal=rs.getInt("sal");
						String econtact=rs.getString("contact");
						System.out.println(eid+"\t"+ename+"\t"+eemail+"\t"+esal+"\t"+econtact);
						
					}
					break;
					
				case 4:
					System.out.println("Enter the id for update");
					int uid=xyz.nextInt();
					xyz.nextLine();
					System.out.println("Enter the name");
					String mname=xyz.nextLine();
					value=smt.executeUpdate("update employee set name='"+mname+"' where id="+uid);
					break;
				case 5:
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter the name you want to delete");
					String uname=sc.nextLine();
					value=smt.executeUpdate("delete from employee where name='"+uname+"'");
					if(value>0)
					{
						System.out.println("record delete succesfully.....");
					}
					else
					{
						System.out.println("Record not deleted...");
					}
					break;
					
					default:
						System.out.println("Wrong choice");
			}
		}
		while(true);
	}
}