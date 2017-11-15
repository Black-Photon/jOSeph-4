package jOSeph_4;

import jOSeph_4.resources.controllers.Achievement_Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

	/**
	 * Starts the program
	 * @param args Ignored
	 */
	public static void main(String[] args) {
		launch();
	}


	//Used to create windows easily. Done through main as can't be static
	public static final Windows windows = new Windows();

	/**
	 * Starts the program as if just opened. DO NOT CALL - Done automatically through launch()
	 * @param primaryStage
	 * @throws Exception
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Here to ensure it get's called
		Achievement_Controller.createAchievements();

		Variable.setWindow(primaryStage);
		Variable.getWindow().setTitle("");
		Variable.getConfigFiles().loadConfig( Variable.getDatabase());

		//Sets up Stage
		Variable.getWindow().setOnCloseRequest(e -> {
			quit();
			e.consume();
		});
		Variable.getWindow().getIcons().add(new Image("jOSeph_4/resources/images/BasicLogo.png"));

		Main.createWindow("Launcher.fxml",Variable.getWindow(), "jOSeph " + Variable.getVersionObject().versionToString());
		Variable.getWindow().show();
	}

	/**
	 * Start's the load part
	 * @throws IOException
	 */
	public static void startLoad() throws IOException{
		Main.createWindow("Load.fxml", Variable.getWindow(), "Loading...");
	}

	/**
	 * Start's Core
	 */
	public static void coreProgramStart(){
		//Twice to prevent glitch
		Main.createWindow("Core.fxml",Variable.getWindow(),"jOSeph " + Variable.getVersionObject().versionToString());
		Main.createWindow("Core.fxml",Variable.getWindow(),"jOSeph " + Variable.getVersionObject().versionToString());
	}

	/**
	 * Call to create a window, with given FXML file, window, and title
	 * @param location Location of FXML file from the jOSeph_4/resources/fxml folder (eg. Load.fxml, quiz/Feedback.fxml)
	 * @param window Window to display to
	 * @param title Title of window
	 */
	public static void createWindow(String location, Stage window, String title){
		windows.createWindow(location, window, title,"jOSeph_4/resources/fxml/");
	}
	/**
	 * Call to create a window WITHOUT setting the scene, with given FXML file, window, and title
	 * @param location Location of FXML file from the jOSeph_4/resources/fxml folder (eg. Load.fxml, quiz/Feedback.fxml)
	 * @param window Window to display to
	 * @param title Title of window
	 * @return The scene built
	 */
	public static Scene buildWindow(String location, Stage window, String title){
		return windows.buildWindow(location, window, title,"jOSeph_4/resources/fxml/");
	}

	/**
	 * Anything that must be done before closing the program should go here.
	 * Call to close the program
	 */
	public static void quit(){
		System.out.println("System closed successfully");
		Variable.getWindow().close();
	}
}