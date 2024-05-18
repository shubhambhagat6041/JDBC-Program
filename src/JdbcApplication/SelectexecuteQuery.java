package JdbcApplication;
import java.sql.*;
import java.util.*;
public class SelectexecuteQuery
{
	public static void main(String x[])throws SQLException
	{
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		if(conn!=null)
		{
			System.out.println("Database connected Succesfully");
			Statement smt=conn.createStatement();
			ResultSet rs=smt.executeQuery("Select *from employee");
			while(rs.next())
			{
				int empid=rs.getInt("id");
				String name=rs.getString("name");
				int salary=rs.getInt("salary");
				System.out.println(empid+"\t"+name+"\t"+salary);
			}
		}
		else
		{
			System.out.println("Database Not Connected.......");
		}
		
	}
}
