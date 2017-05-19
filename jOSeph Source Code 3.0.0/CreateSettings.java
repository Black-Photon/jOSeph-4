package questionareGui;

import java.io.File;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CreateSettings {

	//So complex i'm just leaving it for now. You shouldn't need to use it much
	
	private static Scanner read;
	public static HashMap<String, String> load(boolean create, HashMap<String, String> data){
		HashMap<String, String> database = new HashMap<String, String>();
		File use = new File("jOSeph_config.txt");
		
		
		if(use.isFile()){
			loadFile();
			database = readFile();
		}else{
			database.put("Ele20002", "Triangle");
			database.put("Guest", "Admin");
			database.put("Megan", "Password");
			database.put("Tom", "Tom");
		}
		if(data!=null){
			database=data;
			
		}
		if(create){
			createFile();
			writeFile(database);
			closeFile();
			return null;
		}else{
			loadFile();
			return readFile();
		}
		
	}
	private static Formatter file;
	public static void createFile(){
		try{
			file = new Formatter("jOSeph_config.txt");
		}catch(Exception e){
			AlertBox_GUI.display("Error...", "Error trying to write a new file", "Return", 300);
		}
		File use = new File("jOSeph_config.txt");
		try{
			read = new Scanner(use);
		}catch(Exception e){
			System.out.println("Error?");
		}
	}
	public static void loadFile(){
		File use = new File("jOSeph_config.txt");
		try{
			read = new Scanner(use);
		}catch(Exception e){
			System.out.println("Error");
		}
		
	}
	public static void writeFile(HashMap<String, String> x){
		int z = 0;
		while(z<x.size()){
			Set<String> keyset=x.keySet();
			//System.out.printf("%s %s\n",keyset.toArray()[z],x.get(keyset.toArray()[z]));
			file.format("%s %s ",keyset.toArray()[z],x.get(keyset.toArray()[z]));
			z++;
		}
	}
	
	public static HashMap<String, String> readFile(){
		HashMap<String, String> database = new HashMap<String, String>();
		String a;
		String b;
		while(read.hasNext()){
			a = read.next();
			b = read.next();
			database.put(a, b);
		}
		return database;
		
	}
	public static void closeFile(){
		file.close();
		
	}
}
