package Practice;
import java.util.*;
class A implements Runnable
{
	public void run() {
		try
		{
			for(int i=1;i<=5;i++)
			{
				System.out.println("I==>"+i);
				Thread.sleep(1000);
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error is:"+ex);
		}
	}
	
}
public class practice
{	public static void main(String x[]) throws InterruptedException 
	{	Scanner xyz=new Scanner(System.in);
		A a=new A();
		Thread t=new Thread(a);
		t.start();
	}
}