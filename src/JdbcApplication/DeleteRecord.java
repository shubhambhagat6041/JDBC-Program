package JdbcApplication;
import java.sql.*;
import java.util.*;
public class DeleteRecord 
{
	public static void main(String x[])throws SQLException
	{
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham", "root", "root");
		if(conn!=null)
		{
			System.out.println("Database Connected");
			System.out.println("Enter the id you want to delete");
			int eid=xyz.nextInt();
			Statement smt=conn.createStatement();
			int value=smt.executeUpdate("delete from employee where id="+eid);
			if(value>0)
			{
				System.out.println("Record Deleted Succesfully...");
			}
			else
			{
				System.out.println("Record Not Deleted");
			}
		}
		else
		{
			System.out.println("Database Not Connected");
		}
	}
}
