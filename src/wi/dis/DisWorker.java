package wi.dis;

import java.io.PrintWriter;
import java.util.Random;

public class DisWorker{
	
	public static void main(String[] args)throws Exception{
		int count = new Random().nextInt(10);
		String name = System.currentTimeMillis()+"-"+count+".txt";
		PrintWriter pw = new PrintWriter(name);
		pw.println("number =" + count);
		for(int i = 0;i < count;i ++){
			Thread.sleep(1000);
			pw.println(System.currentTimeMillis()+","+count);
		}
		pw.close();
	}
	

}
