import java.io.*;
import java.sql.*;
public class CSVReadandLoad 
{

	public static void main(String[] args) throws Exception
	{
		FileReader fr=new FileReader("C:\\Users\\dell\\Desktop\\Advance Java\\demo.csv");
		BufferedReader br=new BufferedReader(fr);
		String data;
		int count=0;
		boolean b=false;
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student_examination","root","root");
		if(conn!=null)
		{	
			
			while((data=br.readLine())!=null)
			{
				String []cols=data.split(",");
				//System.out.println(++count+"\t"+cols[0]+"\t"+cols[1]);
				PreparedStatement pmt=conn.prepareStatement("insert into employee values('0',?,?)");
				pmt.setString(1, cols[0]);
				pmt.setInt(2,Integer.parseInt(cols[1]));
				int value=pmt.executeUpdate();
				if(value>0)
				{
					b=true;
				}
			}
			if(b)
			{
				System.out.println("Record uploaded..........");
			}
			else
			{
				System.out.println("Some problem there...........");
			}
			
		}	

	}

}
