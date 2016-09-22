import java.util.concurrent.*;
import java.util.*;


public class Monitor{
	private int clientId = -1;
	private String pageContents;
	
	final int READ = 0;
	final int WRITE = 1;
	
	public Monitor()
	{
		
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
			System.out.println("Please type in word: ");

			myTurn = 2;
		}catch (Exception exception) {
			exception.printStackTrace();
		}
	
	notifyAll();
	}
	
	public void readRequest(){

	}
	
	public void writeRequest(){

	}
}
