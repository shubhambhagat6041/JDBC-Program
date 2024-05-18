package JdbcApplication;
import java.sql.*;
import java.util.*;

import com.mysql.cj.jdbc.Driver;
public class FetchDataById
{
	public static void main(String x[])throws SQLException
	{	
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root","root");
		if(conn!=null)
		{
			System.out.println("Database Connected Succesfully......");
			System.out.println("Enter the id you want to search");
			int sid=xyz.nextInt();
			Statement smt=conn.createStatement();
			ResultSet rs=smt.executeQuery("select *from employee where id="+sid);
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
			}
			else
			{
				System.out.println("Record not found");
			}
		}
	}

}
