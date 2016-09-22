import java.util.concurrent.*;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ServerThread extends Thread{
	private HashMap<Integer, String> hmap = new HashMap<Integer, String>();
	private File init = new File("init_buffer_pages.dat");
	private Scanner in;
	
	public ServerThread(){
		//super(name);
		readInitBuffer();
	}
	
	public run(){
		
	}
	
	public void readInitBuffer(){
		try{
			in = new Scanner(init);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		while(in.hasNextLine()){
            String line = in.nextLine();
			String[] parts = line.split(" ");
			hmap.put(Integer.parseInt(parts[0]), parts[1]);
        }
		
		/*for (Map.Entry<Integer, String> entry : hmap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("key, " + key + " value " + value);
		}*/	
	}
}
