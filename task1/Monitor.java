import java.util.concurrent.*;
import java.util.*;


public class Monitor{
	public int clientId;
	private String pageContents;
	
	final int READ = 0;
	final int WRITE = 1;
	
	public Monitor(String page) {
		pageContents = page;
		clientId = -1;
	}

	public void sendRequest(String[] request){
		clientId = Integer.parseInt(request[0]);
		clientId = Integer.parseInt(request[1]);
		pageContents = request[2];
	}
	
	public synchronized void setClientId(int clientId){
		this.clientId = clientId;
	}
	
	public synchronized void getPage(int clientId) {
		try {
			 while(this.clientId != clientId){
			 wait();
			 }
			System.out.println("Thread " + clientId + " contents " + pageContents);
			this.clientId = -1;
		}catch (Exception exception) {
			exception.printStackTrace();
		}
	
	notifyAll();
	}
	
	public synchronized void readRequest(int clientId, String pageContents){
		this.clientId = clientId;
		this.pageContents = pageContents;
		notifyAll();
	}
	
	public void writeRequest(){

	}
}
