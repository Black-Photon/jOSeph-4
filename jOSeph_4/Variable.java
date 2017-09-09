package jOSeph_4;

import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;

public class Variable {

	//Variables go here

	//Substitutes primaryStage with window to readability (Hopefully)
	private static Stage window;

	private static Version versionObject = new Version();
	private static HashMap<String,String> database = new HashMap<>();
	private static Files configFiles = new Files();
	private static Files notesFiles = new Files();
	private static String user;
	private static final String configLocation = "jOSeph_config.txt";
	private static File mainFile = new File(configLocation);

	//Getters and Setters

	public static Stage getWindow() {
		return window;
	}

	public static void setWindow(Stage primaryStage){
		window = primaryStage;
	}

	public static Version getVersionObject() {
		return versionObject;
	}

	public static void setVersionObject(Version versionObject) {
		Variable.versionObject = versionObject;
	}

	public static HashMap<String, String> getDatabase() {
		return database;
	}

	public static void setDatabase(HashMap<String, String> database) {
		Variable.database = database;
	}

	public static Files getConfigFiles() {
		return configFiles;
	}

	public static void setConfigFiles(Files files) {
		Variable.configFiles = files;
	}

	public static File getMainFile() {
		return mainFile;
	}

	public static void setMainFile(File mainFile) {
		Variable.mainFile = mainFile;
	}

	public static String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Variable.user = user;
	}

	public static String getConfigLocation() {
		return configLocation;
	}

	public static Files getNotesFiles() {
		return notesFiles;
	}

	public static void setNotesFiles(Files notesFiles) {
		Variable.notesFiles = notesFiles;
	}
}