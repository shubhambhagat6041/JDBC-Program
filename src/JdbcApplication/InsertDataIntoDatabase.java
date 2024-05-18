package JdbcApplication;
import java.sql.*;
public class InsertDataIntoDatabase
{
	public static void main(String x[])throws SQLException
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		if(conn!=null)
		{
			Statement smt=conn.createStatement();
			int value=smt.executeUpdate("insert into employee values(1,'ram',45000)");
			if(value>0)
			{
				System.out.println("Databse stored successfully");
			}
			else
				System.out.println("Database not stored somthin problem there.....");
		}
		else
		{
			
		}
	}
}
