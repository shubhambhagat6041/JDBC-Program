package examProject;
import java.util.*;
import java.sql.*;
public class CreatetableForProject 
{
	public static void main(String x[])throws SQLException
	{	Scanner xyz=new Scanner(System.in);
		
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcapp","root","root");
		PreparedStatement pmt;
		int choice;
			do
			{
				System.out.println("Enter the choice");
				choice=xyz.nextInt();
				switch(choice)
				{
					case 1:
						pmt=conn.prepareStatement("create table subject(sid int(5)primary key auto_increment,subjectname varchar(200)not null unique);");
						int value=pmt.executeUpdate();
						if(value<1)
						{
							System.out.println("Table created");
						}
						else
						{
							System.out.println("not created");
						}
						break;
						
					case 2:
						pmt=conn.prepareStatement("create table question(qid int(5)primary key auto_increment,question varchar(700)not null unique,op1 varchar(200)not null,op2 varchar(200)not null,op3 varchar(200)not null,op4 varchar(200) not null,answer int(5)not null);");
						value=pmt.executeUpdate();
						if(value<1)
						{
							System.out.println("Table created");
						}
						else
						{
							System.out.println("Table not created");
						}
						break;
						
					case 3:
						pmt=conn.prepareStatement("create table subjectquestionjoin(qid int(5),foreign key(qid)references question(qid)on delete cascade,sid int(5),foreign key(sid) references subject(sid)on delete cascade on update cascade);");
						value=pmt.executeUpdate();
						if(value<1)
						{
							System.out.println("table created");
						}
						else
						{
							System.out.println("not creatd");
						}
						break;
						
					case 4:
						pmt=conn.prepareStatement("create table exam(examid int(5)primary key auto_increment,examname varchar(200)not null unique,totalmarks int(5)not null,passingmarks int(5)not null);");
						value=pmt.executeUpdate();
						if(value<1)
						{
							System.out.println("table created");
						}
						else
						{
							System.out.println("not created");
						}
						break;
				}
			}
			while(true);
	}
}
