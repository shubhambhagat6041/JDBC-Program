package JdbcApplication;
import java.sql.*;
import java.util.*;
public class preparedStatementUSinginsertData
{
	public static void main(String x)throws SQLException
	{
		PreparedStatement psmt;
		Scanner xyzScanner=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root","root");
		if(conn!=null)
		{
			System.out.println("Database Connected");
				psmt=conn.prepareStatement("insert into employee(?,?,?)");
			psmt.setInt(1, 5);
			psmt.setString(2, "adi");
			psmt.setInt(3, 78452);
			int value=psmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Record save");
			}
			else
			{
				System.out.println("Record not save");
			}
		}
		else
		{
			System.out.println("Database Connected");
		}
	}
}
