package Practice;
import java.sql.*;
import java.util.*;
public class JdbcApp
{	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		Scanner xyz=new Scanner(System.in);
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","root");
		System.out.println("Enter the id");
		int id=xyz.nextInt();
		xyz.nextLine();
		System.out.println("Enter the Name");
		String name=xyz.nextLine();
		System.out.println("Enter the Salary");
		int salary=xyz.nextInt();
		CallableStatement cal=conn.prepareCall("call saveEmplo(?,?,?)");
		cal.setInt(1,id);
		cal.setString(2, name);
		cal.setInt(3, salary);
		
		boolean b=cal.execute();
		if(!b)
		{
			System.out.println("Procedure Excecute Succesfully.....");
		}
		else
		{
			System.out.println("Not Execute");
		}
	}
}
