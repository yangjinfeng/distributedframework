package wi.dis;

import java.io.PrintWriter;
import java.util.Random;

public class DisLastWorker {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		int count = new Random().nextInt(10);
		String name = System.currentTimeMillis()+"-"+count+"-last.txt";
		PrintWriter pw = new PrintWriter(name);
		pw.println("number =" + count);
		for(int i = 0;i < count;i ++){
			Thread.sleep(1000);
			pw.println(System.currentTimeMillis()+","+count);
		}
		pw.close();
	}

}
