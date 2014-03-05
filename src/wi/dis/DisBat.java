package wi.dis;


public class DisBat extends Thread{
	private String cmd;
	
	
	
	public DisBat(String cmd) {
		this.cmd = cmd;
	}



	public void run(){
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			p.waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
