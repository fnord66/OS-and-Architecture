import java.util.concurrent.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServerThread extends Thread{
	private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	private ArrayList<String> requests = new ArrayList<String>();
	
	private Scanner in;
	private File initFile = new File("init_buffer_pages.dat");
	private File requestFile = new File("all_requests.dat");
	
	private Monitor monitor;
	private int currentRequest = 0;
	
	public ServerThread(String name, Monitor monitor){
		super(name);
		this.monitor = monitor;
		readInitBuffer();
		
	}
	
	public void run(){
		while(currentRequest < requests.size()){
			try{
				while(monitor.clientId != -1){
					wait();
				}
			}
			catch(Exception e){
				System.out.println("server thread wait exception");
			}
			System.out.println(requests.get(currentRequest));
			String[] tokenisedRequest = requests.get(currentRequest).split(" ", 3);
			
			//System.out.println("HEEEEERRRRREE:  " + tokenisedRequest[3]);
			
			
			
			if(tokenisedRequest[1].equals("read")){
				monitor.readRequest(Integer.parseInt(tokenisedRequest[0]), hmap.get((Integer.parseInt(tokenisedRequest[2]))));
			}
			else{
				
			}
			
			/*for(int i = 0; i < tokenisedRequest.length; i++){
				System.out.println(tokenisedRequest[i]);
			}*/

			currentRequest++;
		}
		//monitor.sendRequest(requests.getNext().split());

		//monitor.
	}
	
	public void readInitBuffer(){
		
		initFile(initFile);
		
		while(in.hasNextLine()){
            String line = in.nextLine();
			String[] parts = line.split(" ");
			hmap.put(Integer.parseInt(parts[0]), parts[1]);
        }
		
		initFile(requestFile);
		
		while(in.hasNextLine()){
			String line = in.nextLine();
			requests.add(line);
        }
		
		/*for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key, " + key + " value " + value);
		}*/	
	}
	
	public void initFile(File loadFile)
	{
		try{
			in = new Scanner(loadFile);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
