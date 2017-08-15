package jOSeph_4;

import java.io.File;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Files {
	//Variables
	private Scanner read;

	private Formatter file;

	/* If 'create' is true, it creates the file. Otherwise, it simply reads it. It should be made on every load
	 *
	 * The 'data' is what the file will be set to once made - use to keep old data and reload to temp system vars
	 *
	 * I copied this from jOSeph 3, so it may not be fully stable - by now I've forgotten how it works!
	 */


	public HashMap<String, String> load(boolean create, HashMap<String, String> data){
		if(Main.getVars().getMainFile().isFile()){
			loadFile();
			Main.getVars().setDatabase(readFile());
		}else{
			Main.getVars().getDatabase().put("Ele20002", "Triangle");
			Main.getVars().getDatabase().put("Guest", "Admin");
			Main.getVars().getDatabase().put("Tom", "Tom");
		}
		if(data!=null){
			Main.getVars().setDatabase(data);

		}
		if(create){
			createFile();
			writeFile(Main.getVars().getDatabase());
			closeFile();
			return null;
		}else{
			loadFile();
			return readFile();
		}

	}
	private void createFile(){
		try{
			file = new Formatter("jOSeph_config.txt");
		}catch(Exception e){
			//TODO Add Error Message
			//AlertBox_GUI.display("Error...", "Error trying to write a new file", "Return", 300);
		}
		File use = new File("jOSeph_config.txt");
		try{
			read = new Scanner(use);
		}catch(Exception e){
			System.out.println("Error?");
		}
	}
	private void loadFile(){
		File use = new File("jOSeph_config.txt");
		try{
			read = new Scanner(use);
		}catch(Exception e){
			System.out.println("Error");
		}

	}
	private void writeFile(HashMap<String, String> x){
		int z = 0;
		while(z<x.size()){
			Set<String> keyset=x.keySet();
			//System.out.printf("%s %s\n",keyset.toArray()[z],x.get(keyset.toArray()[z]));
			file.format("%s %s ",
					keyset.toArray()[z],
					Encryption.encrypt(x.get(keyset.toArray()[z]),"yu53efae98uafe05"));
			z++;
		}
	}

	private HashMap<String, String> readFile(){
		String a;
		String b;
		while(read.hasNext()){
			a = read.next();
			b = Encryption.decrypt(read.next(),"yu53efae98uafe05");
			Main.getVars().getDatabase().put(a, b);
		}
		return Main.getVars().getDatabase();//"yu53efae98uafe05"

	}
	private void closeFile(){
		file.close();

	}
}
