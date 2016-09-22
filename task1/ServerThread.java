import java.util.concurrent.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServerThread extends Thread{
	private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	private ArrayList<String> requests = new ArrayList<String>();
	private File initFile = new File("init_buffer_pages.dat");
	private File requestFile = new File("all_requests.dat");
	private Scanner in;
	
	public ServerThread(){
		//super(name);
		readInitBuffer();
	}
	
	/*public run(){
		readRequest();
	}*/
	
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
			System.out.println(line);
        }
		
		for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key, " + key + " value " + value);
		}	
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
