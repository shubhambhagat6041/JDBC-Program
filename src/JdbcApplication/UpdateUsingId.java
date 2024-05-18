package JdbcApplication;
import java.sql.*;
import java.util.*;
public class UpdateUsingId
{
	public static void main(String x[])throws SQLException
	{
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		if(conn!=null)
		{
			System.out.println("Database Connected");
			Statement smt=conn.createStatement();
			System.out.println("Enter the id");
			int id=xyz.nextInt();
			System.out.println("Enter the Salary you want to update");
			int salary=xyz.nextInt();
			xyz.nextLine();
			System.out.println("Enter the Name you want to update");
			String name=xyz.nextLine();
			int value=smt.executeUpdate("update employee set salary="+salary+",name='"+name+"'where id="+id);
			if(value>0)
			{
				System.out.println("Record Update Succesfully.....");
			}
			else
			{
				System.out.println("Some problem there.....");
			}
		}
		else
		{
			System.out.println("Database not connected");
		}
	}
}
