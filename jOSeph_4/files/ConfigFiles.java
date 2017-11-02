package jOSeph_4.files;

import jOSeph_4.Encryption;
import jOSeph_4.Variable;
import jOSeph_4.messageBoxes.sourceFiles.Error;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class ConfigFiles extends Files {
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
			new Error("Error #0006: IOException at ConfigFiles.java", 500).showModalWindow();
		}
	}

	/**
	 * Loads the config file, writing the given data to it
	 * @param data To write to the file
	 * @throws IOException
	 */
	public void loadAndWriteConfig(HashMap<String, String> data) throws IOException{
		createFile(Variable.getConfigLocation());
		loadFile(Variable.getMainFile());
		writeFile(data);
		closeFile();
	}

	/**
	 * 	Reads file and puts into database
	 */
	void readConfigFile(HashMap<String,String> data){
		String a;
		String b;
		while(scanner.hasNext()){
			a = scanner.next();
			b = scanner.next();
			data.put(a, b);
		}
	}

	/**
	 * Simply adds default username's and passwords to the database
	 *
	 * @param data To add
	 */
	void addDefaultConfigData(HashMap<String,String> data){
		data.put("Ele20002", Encryption.hashEncrypt("Triangle"));
		data.put("Guest", Encryption.hashEncrypt("Admin"));
		data.put("Tom", Encryption.hashEncrypt("Tom"));
	}

	/**
	 * Writes the database to the file
	 *
	 * @param data To write
	 */
	void writeFile(HashMap<String, String> data){
		Set<String> keyset = data.keySet();
		for(int i = 0; i<data.size(); i++){
			formatter.format("%s %s ", keyset.toArray()[i], data.get(keyset.toArray()[i]));
		}
	}
}
