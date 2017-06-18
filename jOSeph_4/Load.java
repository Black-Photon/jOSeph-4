package jOSeph_4;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;

import java.util.Random;

/* Creates a class to control the load scene(s)
 * BEWARE, THE WHOLE LOAD SCREEN IS COMPLETE NONSENSE. THIS IS THE REASON FOR THE NEW SKIP BUTTON
 *
 *
 *
 */

public class Load implements Runnable{

	private VBox layout;
	private ProgressBar bar;
	private Label label;
	private Button skip;
	private Scene scene;

	public Load(String message, double progress){
		//System.out.println("construct: " + this);
		layout = new VBox(20);
		bar = new ProgressBar(progress);
		label = new Label(message);
		skip = new Button("Skip");
		layout.setAlignment(Pos.CENTER);
	}

	public void startLoad(){
		//System.out.println("startLoad: " + this);
		layout.getChildren().addAll(label,bar,skip);
		scene = new Scene(layout, 350, 200);
		scene.getStylesheets().addAll("jOSeph_4/resources/css/load.css");
		Main.getVars().getWindow().setScene(scene);
		Main.getVars().getWindow().setTitle("Loading...");

		bar.setProgress(0.5);
		bar.setId("progress");

		skip.setOnAction(e -> {Main.coreProgramStart();});
	}

	public void run(){
		System.out.println("run()");
		startLoad();
	}








	public static void loadController(){
		Load load = new Load("Getting jOSeph ready...",0.0);
		load.startLoad();

		//Waits a while and creates a new object which replaces the scene
		//TODO Can be optimised with Threads - Come back once learned
		//IMPORTANT - BELOW IS THE NONSENSE MENTIONED IN HEADER

		Load loadProblem = new Load("Until I manage to fix load, this is all there is", 1.0);
		waitLoad(loadProblem, 2500);

		Main.coreProgramStart();

		//As usual, doesn't work. Don't uncomment without intent to fix, or show brokenness
		/*Load load1 = new Load("Configurating Settings...", 0.1);
		waitLoad(load1, 1500);

		Load load2 = new Load("Saving Files to C:/Java/System/Projects...", 0.2);
		waitLoad(load2, 2000);

		Load load3 = new Load("Searching for Updates...", 0.3);
		waitLoad(load3, 2500);

		Load load4 = new Load("Starting Launcher...", 0.4);
		waitLoad(load4, 6500);

		//Creates a random number to 7, claims that number of dictionaries is installed
		Random random = new Random();
		int dictionaries = random.nextInt(7);

		//Seperate to avoid anyone noticing links between a shown and mysterious feature
		int update = random.nextInt(3);

		Load load5 = new Load("Downloaded " + dictionaries + " dictionaries...", 0.5);
		waitLoad(load5, 1500);

		if(update == 2) {
			Load load6 = new Load("Update found...", 0.6);
			waitLoad(load6, 750);

			Load load7 = new Load("Downloading update...", 0.7);
			waitLoad(load7, 3000);

			Load load8 = new Load("Update downloaded", 0.8);
			waitLoad(load8, 750);

			Load load9 = new Load("Loading Completed", 0.9);
			waitLoad(load9, 750);
		}else{
			Load load6 = new Load("No Update found", 0.6);
			waitLoad(load6, 750);

			Load load7 = new Load("Quantifying photons...", 0.7);
			waitLoad(load7, 750);

			Load load8 = new Load("Proving Differentiation...", 0.8);
			waitLoad(load8, 750);

			Load load9 = new Load("Writing Nonsense", 0.9);
			waitLoad(load9, 750);
		}
		Load load10 = new Load("Good to Go!", 1.0);
		waitLoad(load10, 1000);

*/


	}



	//Method to do the waiting and loading
	public static void waitLoad(Load load, int time){
		try {
			Thread.sleep(time);
		}catch(Exception e){
			Error error = new Error("Error", 500);
			error.setLabel("Exception at class Load, contact admin");
			e.printStackTrace();
		}
		load.startLoad();
	}
}
