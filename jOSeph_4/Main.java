package jOSeph_4;

import jOSeph_4.resources.controllers.Achievement_Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

	//Main Method
	public static void main(String[] args) {
		launch();
	}

	public static final Windows windows = new Windows();

	@Override
	public void start(Stage primaryStage) throws Exception {
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

		new Launcher().start();
		Variable.getWindow().show();
	}

	public static void startLoad() throws IOException{
		new Load().startLoad();
	}

	public static void coreProgramStart(){
		new Core().start();
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

	//Quit
	public static void quit(){
		System.out.println("System closed successfully");
		Variable.getWindow().close();
	}
}