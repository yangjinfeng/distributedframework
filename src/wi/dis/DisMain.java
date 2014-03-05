package wi.dis;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Properties;

public class DisMain extends Thread{
	private ArrayList<Thread> tasks = new ArrayList<Thread>();
	private ArrayList<Thread> lasttasks = new ArrayList<Thread>();
	
	public DisMain(){
		loadTasks();
	}
	
	private void loadTasks(){
		Properties prop = new Properties();
		try {
			prop.load(new FileReader("bat-config.properties"));
			Enumeration<?> pnames = prop.propertyNames();
			while(pnames.hasMoreElements()){
				String pn = (String)pnames.nextElement();
				if(pn.startsWith("task")){
					addTask(new DisBat(prop.getProperty(pn)));
				}else if(pn.startsWith("lasttask")){
					addLastTask(new DisBat(prop.getProperty(pn)));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addTask(Thread task){
		tasks.add(task);
	}
	
	public void addLastTask(Thread task){
		lasttasks.add(task);
	}

	public static void main(String[] args) throws Exception{
		
		DisMain main = new DisMain();		
		main.start();
		
		
	}
	
	public void run(){
		
		//每一个task可以同时进行
		for(Thread task : tasks){
			task.start();
		}
		
		for(Thread task : tasks){
			try{
				task.join();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		//每一个lasttask只能顺序执行
		for(Thread task : lasttasks){
			task.start();
			try {
				task.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
		
}
