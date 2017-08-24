package jOSeph_4;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * File from jOSeph 3 optimised for jOSeph 4
 *
 * Imagine the formatter to be the file
 */

public class Files {

	//Variables
	private Scanner scanner;

	private Formatter formatter;

	/**
	 * Loads, reads and writes to the config file
	 * @param data Blank database to save to
	 */
	public void loadConfig(HashMap<String, String> data){
		try {
			if(fileExists(Variable.getMainFile())){
				loadFile(Variable.getMainFile());
				readFile(data);
			}else{
				addDefaultConfigData(data);
			}
			loadAndWriteConfig(data);
			Variable.setDatabase(data);
		}catch (IOException e){
			e.printStackTrace();
			new Error("Error #0006: IOException at Files.java", 500);
		}
	}
	public void loadAndWriteConfig(HashMap<String, String> data) throws IOException{
		createFile(Variable.getConfigLocation());
		writeFile(data);
		closeFile();
	}
	//Creating a formatter creates a file
	private void createFile(String location) throws IOException{
		formatter = new Formatter(location);
	}
	//Creating a scanner allows the file to be read
	private void loadFile(File file) throws IOException{
		scanner = new Scanner(file);
	}
	//Writes the database to the file
	private void writeFile(HashMap<String, String> data){
		Set<String> keyset = data.keySet();
		for(int i = 0; i<data.size(); i++){
			formatter.format("%s %s ", keyset.toArray()[i], data.get(keyset.toArray()[i]));
		}
	}
	//Reads file and puts into database
	private void readFile(HashMap<String,String> data){
		String a;
		String b;
		while(scanner.hasNext()){
			a = scanner.next();
			b = scanner.next();
			data.put(a, b);
		}
	}
	//The formatter is the only thing need be closed
	private void closeFile(){
		formatter.close();
	}
	private boolean fileExists(File file){
		return file.isFile();
	}

	//Simply adds default username's and passwords to the database
	private void addDefaultConfigData(HashMap<String,String> data){
		data.put("Ele20002", Encryption.hashEncrypt("Triangle"));
		data.put("Guest", Encryption.hashEncrypt("Admin"));
		data.put("Tom", Encryption.hashEncrypt("Tom"));
	}
}



















