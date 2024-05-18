package JdbcApplication;
import java.sql.*;
public class RegisterDriverApp
{
	public static void main(String x[]) throws Exception
	{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		System.out.println("Registerd Successfully...");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root", "root");
		if(conn!=null)
		{
			Statement stm=conn.createStatement();
			System.out.println("Databse connected");
		}
		else
		{
			System.out.println("Some problem there.....");
		}
	}
}
