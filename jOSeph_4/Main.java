package jOSeph_4;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{

	//Main Method
	public static void main(String[] args) {
		launch();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		Variable.setWindow(primaryStage);
		Variable.getWindow().setTitle("");
		Variable.getConfigFiles().loadConfig( Variable.getDatabase());

		//Sets up Stage
		Variable.getWindow().setOnCloseRequest(e -> {
			quit();
			e.consume();
		});
		Variable.getWindow().getIcons().add(new Image("jOSeph_4/resources/images/BasicLogo.png"));
		Variable.getWindow().setTitle("jOSeph " + Variable.getVersionObject().bToString());

		new Launcher().start();
	}

	public static void startLoad() throws IOException{
		Load load = new Load();
		load.startLoad();
	}

	public static void coreProgramStart(){
		Core core = new Core();
		try {
			core.start();
		} catch (IOException e) {
			new Error("Error #0004: IOException at Main.java",400);
			e.printStackTrace();
		}
	}

	//Quit
	public static void quit(){
		System.out.println("System closed successfully");
		Variable.getWindow().close();
	}
}