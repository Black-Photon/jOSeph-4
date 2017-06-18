package jOSeph_4;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Iterator;

public class Main extends Application{

	//Variables
	private static Variable vars;

	//Main Method
	public static void main(String[] args) {
		launch();
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		vars = new Variable(primaryStage);
		vars.getWindow().setTitle("");
		if (vars.getMainFile().isFile() == false) {
			vars.getFiles().load(true, null);
		} else {
			vars.getFiles().load(true, vars.getDatabase());
		}
		//System.out.println(vars.getDatabase());

		//Sets up Stage
		vars.getWindow().setOnCloseRequest(e -> {
			quit();
			e.consume();
		});
		vars.getWindow().getIcons().add(new Image("jOSeph_4/resources/images/BasicLogo.png"));
		vars.getWindow().setTitle("jOSeph " + vars.getVersionObject().bToString());

		Launcher launcher = new Launcher();
		vars.getWindow().setScene(launcher.getScene());
		vars.getWindow().show();

	}

	public static void coreProgramStart(){
		Core core = new Core();
		core.start();
	}



	//Getters and Setters

	public static Variable getVars() {
		return vars;
	}


	//Quit
	public static void quit(){
		System.out.println("System closed successfully");
		vars.getWindow().close();
	}
}
