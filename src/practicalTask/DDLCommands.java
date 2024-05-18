
package practicalTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DDLCommands {

		public static void main(String[] args) {
			
				try {
					
				
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shubham","root","root");
					Statement stm = conn.createStatement();
					
					int value = stm.executeUpdate(" create table product (pid int primary key auto_increment,pname varchar(100),price int(5))"); 
					if(value<1) {
						System.out.println("yess");
					}else {
						System.out.println("No");
					}
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				
		}
}
