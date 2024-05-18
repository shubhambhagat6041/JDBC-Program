package JdbcApplication;
import java.sql.*;
import java.util.*;
public class UserInputInser 
{
	public static void main(String x[])throws SQLException
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		if(conn!=null)
		{	System.out.println("Database Connected");
			Scanner xyz=new Scanner(System.in);
			Statement smt=conn.createStatement();
			System.out.println("Enter the Employee id");
			int eid=xyz.nextInt();
			xyz.nextLine();
			System.out.println("Enter the Employee Name");
			String name=xyz.nextLine();
			System.out.println("Enter the Salary");
			int salary=xyz.nextInt();
			int value=smt.executeUpdate("insert into employee values("+eid+",'"+name+"',"+salary+")");
			if(value>0)
			{
				System.out.println("Database save succesfully");
			}
			else
			{
				System.out.println("Database not save.....");
			}
		}
		else
		{
			System.out.println("Database not connected");
		}
	}
}
