package practicalTask;
import java.sql.*;
import java.util.*;
public class PreparedStatePracticalTask {
	public static void main(String x[])throws SQLException
	{
		Scanner xyz=new Scanner(System.in);
		int choice,value;
		int sid,salary;
		String sname,email;
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		PreparedStatement pmt;
		ResultSet rs;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root","root");
		do
		{
			System.out.println("1:create table employee");
			System.out.println("2:Insert Record in employee table using field eid,ename,eemail,esal,econtact");
			System.out.println("3:Display All Record Of Employee");
			System.out.println("4:WA Sql query to display all employee whose id is 1 and name is ram as well as salary is greater than 10000");
			System.out.println("5:WA sql query to display all employee whose name is not ram and salary is not 10000");
			System.out.println("6:WA sql query to display all employee whose name is ram and salary is not 20000");
			System.out.println("7:WA sql query to display all employee whose salary is 20000 and and email is shyam @gmail.com ");
			System.out.println("8:WA sql query to display all employee whose salary is less than 30000 and name is ramesh");
			System.out.println("9:Wa sql query to update Employee whose id is 2 or name is shyam ");
			System.out.println("10:Display employee Record whose salary is 10000,20000 and 30000");
			System.out.println("11:Display employee record whose salary is not in 10000,20000 and 30000");
			System.out.println("12:Display employee records whose salary between 10000 and 60000");
			System.out.println("13:Display employee records whose salary is 10000,20000,30000 and name is not ramesh");
			System.out.println("14:Display employee records whose name is ram,shyam,ganesh");
			System.out.println("15:Display employee whose salary is less than 100000 and name is shyam ,dinesh");
			System.out.println("Enter the Choice");
			choice=xyz.nextInt();
			
			switch(choice)
			{
				case 1:
					String q="create table emp(eid int(10)primary key auto_increment,ename varchar(200)not null,eemail varchar(200)not null unique,esal int(10)not null,econtact varchar(200)unique)";
					pmt=conn.prepareStatement(q);
					value=pmt.executeUpdate();
					if(value<1)
					{
						System.out.println("Table created");
					}
					else
					{
						System.out.println("Table not create");
					}
					break;
					
				case 2:
					
					System.out.println("Enter the Salary,name,Email,contact");
					int sal = xyz.nextInt();//2432
					xyz.nextLine();
					String name=xyz.nextLine();//abc
					 email=xyz.nextLine();// abc@gmail.com
					String contact=xyz.nextLine();//23424
					pmt=conn.prepareStatement("insert into emp values('0',?,?,?,?)");
					pmt.setString(1,name);
					pmt.setString(2, email);
					pmt.setInt(3, sal);
					pmt.setString(4, contact);
					value=pmt.executeUpdate();
					if(value>0)
					{
						System.out.println("Record insertd Successfully.......");
					}
					else
					{
						System.out.println("Record not inserted");
					}
					break;
					
				case 3:
					pmt=conn.prepareStatement("select *from emp");
					rs=pmt.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
					}
					
					break;
					
				case 4:
					System.out.println("Enter the id");
					sid = xyz.nextInt();
					xyz.nextLine(); 
					System.out.println("Enter the name");
					 sname = xyz.nextLine();
					System.out.println("Enter the salary");
					salary = xyz.nextInt();
					xyz.nextLine(); 

					pmt = conn.prepareStatement("select * from emp where eid=? and ename=? and esal>=?");
					pmt.setInt(1, sid);
					pmt.setString(2, sname);
					pmt.setInt(3, salary);
					rs = pmt.executeQuery();

					while(rs.next())
					{
					    System.out.println(rs.getInt("eid") + "\t" + rs.getString("ename") + "\t" + rs.getString("eemail") + "\t" + rs.getInt("esal") + "\t" + rs.getString("econtact"));
					}

					break;
					
				case 5:
					xyz.nextLine();
					System.out.println("Enter the name");
					 sname = xyz.nextLine();
					System.out.println("Enter the salary");
					salary = xyz.nextInt();
					
					pmt=conn.prepareStatement("select *from emp where not ename=? and not esal=?");
					pmt.setString(1, sname);
					pmt.setInt(2, salary);
					rs=pmt.executeQuery();
					while(rs.next())
					{
					    System.out.println(rs.getInt("eid") + "\t" + rs.getString("ename") + "\t" + rs.getString("eemail") + "\t" + rs.getInt("esal") + "\t" + rs.getString("econtact"));
					}
					break;
					
				case 6:
					xyz.nextLine();
					System.out.println("Enter the name");
					sname=xyz.nextLine();
					System.out.println("Enter the salary");
					salary=xyz.nextInt();
					pmt=conn.prepareStatement("select *from emp where ename=? and not esal=?");
					pmt.setString(1, sname);
					pmt.setInt(2, salary);
					rs=pmt.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
					}
					break;
					
				case 7:
					System.out.println("Enter the salary");
					salary=xyz.nextInt();
					xyz.nextLine();
					System.out.println("Enter the email");
					email=xyz.nextLine();
					pmt=conn.prepareStatement("select *from emp where esal=? and eemail=?");
					pmt.setInt(1, salary);
					pmt.setString(2, email);
					rs=pmt.executeQuery();
					
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
					}
					break;
					
				case 8:
					xyz.nextLine();
					System.out.println("Enter the name");
					sname=xyz.nextLine();
					System.out.println("Enter the salary");
					salary=xyz.nextInt();
					pmt=conn.prepareStatement("select *from emp where esal<? and ename=?");
					pmt.setInt(1, salary);
					pmt.setString(2, sname);
					rs=pmt.executeQuery();
					while(rs.next())
					{	
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
					}
					
					break;
					
				case 9:
					xyz.nextLine();
					System.out.println("Enter the Name");
					 sname=xyz.nextLine();
					 System.out.println("Enter the id");
					 sid=xyz.nextInt();
					 xyz.nextLine();
					 System.out.println("Enter the contact for update");
					 contact=xyz.nextLine();
					 
					 pmt=conn.prepareStatement("update emp set econtact=? where eid=? and ename=?");
					 pmt.setString(1, contact);
					 pmt.setInt(2, sid);
					 pmt.setString(3, sname);
					 value=pmt.executeUpdate();
					 if(value>0)
					 {
						 System.out.println("Updated succesfully............");
					 }
					 else
					 {
						 System.out.println("not updated");
					 }
					
					break;
					
				case 10:
					System.out.println("Enter the salary 1");
					int salary1=xyz.nextInt();
					System.out.println("Enter the salary 2");
					int salary2=xyz.nextInt();
					System.out.println("Enter the salary 3");
					int salary3=xyz.nextInt();
					pmt=conn.prepareStatement("select *from emp where esal IN(?,?,?)");
					pmt.setInt(1, salary1);
					pmt.setInt(2, salary2);
					pmt.setInt(3, salary3);
					rs=pmt.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
						
					}	
					break;
					
				case 11:
					System.out.println("Enter the salary 1");
					 salary1=xyz.nextInt();
					System.out.println("Enter the salary 2");
					salary2=xyz.nextInt();
					System.out.println("Enter the salary 3");
					salary3=xyz.nextInt();
					pmt=conn.prepareStatement("select *from emp where not esal IN(?,?,?)");
					pmt.setInt(1, salary1);
					pmt.setInt(2, salary2);
					pmt.setInt(3, salary3);
					rs=pmt.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
						
					}	
					break;
					
				case 12:
					System.out.println("Enter the salary 1");
					 salary1=xyz.nextInt();
					System.out.println("Enter the salary 2");
					salary2=xyz.nextInt();
					pmt=conn.prepareStatement("select *from emp where esal between ? and ?");
					pmt.setInt(1, salary1);
					pmt.setInt(2, salary2);
					rs=pmt.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
						
					}	
					break;
					
				case 13:
					System.out.println("Enter the salary 1");
					 salary1=xyz.nextInt();
					System.out.println("Enter the salary 2");
					salary2=xyz.nextInt();
					System.out.println("Enter the salary 3");
					salary3=xyz.nextInt();
					xyz.nextLine();
					System.out.println("Enter the name");
					sname=xyz.nextLine();
					pmt=conn.prepareStatement("select *from emp where esal IN(?,?,?)and not ename=?");
					pmt.setInt(1, salary1);
					pmt.setInt(2, salary2);
					pmt.setInt(3, salary3);
					pmt.setString(4, sname);
					rs=pmt.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
					}
					break;
					
				case 14:
					xyz.nextLine();
					System.out.println("Enter the name1");
					String name1=xyz.nextLine();
					System.out.println("Enter the name2");
					String name2=xyz.nextLine();
					System.out.println("Enter the name3");
					String name3=xyz.nextLine();
					pmt=conn.prepareStatement("select *from emp where ename IN(?,?,?)");
					pmt.setString(1, name1);
					pmt.setString(2, name2);
					pmt.setString(3, name3);
					rs=pmt.executeQuery();
					while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
					}
					break;
					
				case 15:
				   System.out.println("Enter the salary");
				   salary=xyz.nextInt();
				   xyz.nextLine();
				   System.out.println("Enter the name1");
				   name1=xyz.nextLine();
				   System.out.println("Enter the name2");
				   name2=xyz.nextLine();
				   pmt=conn.prepareStatement("select *from emp where esal<=? and ename IN(?,?)");
				   pmt.setInt(1, salary);
				   pmt.setString(2, name1);
				   pmt.setString(2, name2);
				   rs=pmt.executeQuery();
				   while(rs.next())
					{
						System.out.println(rs.getInt("eid")+"\t"+rs.getString("ename")+"\t"+rs.getString("eemail")+"\t"+rs.getInt("esal")+"\t"+rs.getString("econtact"));
					}
					break;
					
					default:
						System.out.println("Wrong choice");
			}
		}
		while(true);
		
	}
}
