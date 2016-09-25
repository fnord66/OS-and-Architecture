import java.util.concurrent.*;
import java.util.*;


public class ClientThread extends Thread{
	private int clientId;
	private Monitor monitor;
	
	public ClientThread(String name, Monitor monitor, int id){
		super(name);
		this.monitor = monitor;
		clientId = id;
	}
	
	public void run(){
		//monitor.getPage(clientId);
	}
}