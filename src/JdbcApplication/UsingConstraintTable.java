//Example: WAP to create table name as register with column id,name , email, contact ,username and password
package JdbcApplication;
import java.sql.*;
import java.util.*;
public class UsingConstraintTable
{
	public static void main(String x[])throws SQLException
	{
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		int value;
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root","root");
		if(conn!=null)
		{
			System.out.println("Database Connected");
			String q="create table register(id int(5)primary key auto_increment,name varchar(200)not null,email varchar(200)not null unique,contact varchar(200)not null unique,username varchar(200)not null unique,password varchar(200)not null unique)";
			Statement smt=conn.createStatement();
			value=smt.executeUpdate(q);
			if(value<1)
			{
				System.out.println("Table created succesfully");
			}
			else
			{
				System.out.println("Table not created");
			}
			
			System.out.println("Enter the name");
			String name=xyz.nextLine();
			System.out.println("Enter the email");
			String email=xyz.nextLine();
			System.out.println("Enter the Contact");
			String contact=xyz.nextLine();
			System.out.println("Enter the username");
			String username=xyz.nextLine();
			System.out.println("Enter the password");
			String password=xyz.nextLine();
			value=smt.executeUpdate("insert into register values('0','"+name+"','"+email+"','"+contact+"','"+username+"','"+password+"')");
			if(value>0)
			{
				System.out.println("Record insert Succesfully...........");
			}
			else
			{
				System.out.println("Record not insert something is problem....");
			}
		}
		else
		{
			System.out.println("Database not connected");
		}
	}
}
