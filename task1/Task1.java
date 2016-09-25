import java.util.concurrent.*;
import java.util.*;


public class Task1 {
  public static void main(String[] args) {
    
	Monitor monitor = new Monitor("initial Page");
	ServerThread server = new ServerThread("Server", monitor);
	//ClientThread[] clientThreads = createClientThreads(Integer.parseInt(args[0]));
	ClientThread[] clientThreads = new ClientThread[3];
	
	server.start();
	
	for(int i = 0; i < clientThreads.length; ++i) {
      clientThreads[i] = new ClientThread("Client Thread " + i, monitor, i);
      clientThreads[i].start();
    }
	
	
	
	
	
	/*SharedString sharedString = new SharedString("initialString");
    PrintThread[] printThreads = new PrintThread[2];
    InputThread inputThread = new InputThread("InputThread", sharedString);
    inputThread.start();
    for(int i = 0; i < 2; ++i) {
      printThreads[i] = new PrintThread("PrintThread" + i, i, sharedString);
      printThreads[i].start();
    }*/
  }
  
  public static ClientThread[] createClientThreads(int args){
	
	ClientThread[] tempClientThreads = null;
	
	try{
		tempClientThreads = new ClientThread[args];
	}
	catch(Exception e){
		e.printStackTrace();
	}
	
	return tempClientThreads;
  }
}
