package jOSeph_4;

import javafx.geometry.Insets;
import javafx.stage.Stage;

import java.io.File;
import java.util.HashMap;
import java.util.Random;

public class Variable {

	//Variables go here

	//Substitutes primaryStage with window to readability (Hopefully)
	private final Stage window;

	private Version versionObject;
	private HashMap<String,String> database;
	private Files files;
	private File mainFile;
	private Insets defaultInsets;

	public Variable(Stage primaryStage) {
		window = primaryStage;
		versionObject = new Version();
		database = new HashMap<>();
		files = new Files();
		mainFile = new File("jOSeph_config.txt");
		defaultInsets = new Insets(20);

	}


	//Getters and Setters

	public Stage getWindow() {
		return window;
	}

	public Version getVersionObject() {
		return versionObject;
	}

	public void setVersionObject(Version versionObject) {
		this.versionObject = versionObject;
	}

	public HashMap<String, String> getDatabase() {
		return database;
	}

	public void setDatabase(HashMap<String, String> database) {
		this.database = database;
	}

	public Files getFiles() {
		return files;
	}

	public void setFiles(Files files) {
		this.files = files;
	}

	public File getMainFile() {
		return mainFile;
	}

	public void setMainFile(File mainFile) {
		this.mainFile = mainFile;
	}

	public Insets getDefaultInsets() {
		return defaultInsets;
	}
}