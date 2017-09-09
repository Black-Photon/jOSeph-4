package jOSeph_4;

import jOSeph_4.messageBoxes.Error;

import java.io.File;
import java.io.IOException;
import java.util.*;

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
				readConfigFile(data);
			}else{
				addDefaultConfigData(data);
			}
			loadAndWriteConfig(data);
			Variable.setDatabase(data);
			closeFile();
			scanner.close();
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
	public void createFile(String location) throws IOException{
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
	private void readConfigFile(HashMap<String,String> data){
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

	public ArrayList<File> getAllTextFiles(String folderName){
		File[] filesArray = getAllFiles(folderName);
		ArrayList<File> files = new ArrayList<>(Arrays.asList(filesArray));
		for(File i: files){
			if(!(i.isFile() && i.getName().endsWith(".txt"))){
				files.remove(i);
			}
		}
		return files;
	}

	public File[] getAllFiles(String folderName){
		File folder = new File(folderName);
		File[] files = folder.listFiles();
		return files;
	}

	public void saveNotes(File file, String text) throws IOException{
		createFile(Variable.getUser()+"/"+file.getName());
		formatter.format(text);
		closeFile();
	}
	public String readNotes(File file) throws IOException{
		loadFile(file);
		String answer = readFile(file);
		scanner.close();
		return answer;
	}
	private String readFile(File file){
		scanner.useDelimiter("\\Z"); //???
		String content = scanner.next();
		return content;
	}

	public void createAndCloseFile(String path){
		try {
			createFile(path);
			formatter.format(" ");
			closeFile();
		}catch(IOException e){
			e.printStackTrace();
			new Error("Error #0014: IOException at Files.java", 600);
		}
	}
}



















