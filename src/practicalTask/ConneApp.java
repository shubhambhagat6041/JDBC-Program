package practicalTask;
import java.sql.*;
import java.util.*;
public class ConneApp 
{
	public static void main(String[] args)throws SQLException
	{	
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
		System.out.println("Enter the id");
		int id=xyz.nextInt();
		xyz.nextLine();
		System.out.println("Enter the name");
		String name=xyz.nextLine();
		System.out.println("Enter the salary");
		int sal=xyz.nextInt();
		PreparedStatement pmt=conn.prepareStatement("insert into employeee values(?,?,?)");
		pmt.setInt(1, id);
		pmt.setString(2, name);
		pmt.setInt(3, sal);
		int value=pmt.executeUpdate();
		if(value>0)
		{
			System.out.println("recod insertd successfully......");
		}
		else
		{
			System.out.println("Some problem there......");
		}
		
	}
}
