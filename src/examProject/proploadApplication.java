package examProject;

import java.io.FileInputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

public class proploadApplication 
{	public static void main(String x[])throws Exception
	{	
		Path currentDirectoryPath = FileSystems.getDefault().getPath("");
		String currentDirectoryName = currentDirectoryPath.toAbsolutePath().toString();
		String completepath=currentDirectoryName+"\\src\\resorces\\db.properties";
		System.out.println("Current Directory = \"" + currentDirectoryName + "\"");
		System.out.println("completepath:"+completepath);
		Properties p=new Properties();
		FileInputStream finf=new FileInputStream("C:\\Users\\dell\\eclipse-workspace\\JDBC APP\\src\\resorces\\db.properties");
		
		p.load(finf);
		String driverClasssName=p.getProperty("driver");
		String urlName=p.getProperty("url");
		String username=p.getProperty("user");
		String password=p.getProperty("pass");
		System.out.println(driverClasssName);
		System.out.println(urlName);
		System.out.println(username);
		System.out.println(password);
	
	}
}
