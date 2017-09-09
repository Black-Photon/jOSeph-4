package jOSeph_4.resources.controllers;

import jOSeph_4.Main;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Load_Controller implements Initializable{
	private Timeline timeline;
	private float timeElapsed;
	@FXML
	public ProgressBar bar;
	public Label label;

	@Override
	public void initialize(URL location, ResourceBundle resources){
		//BEWARE, THE WHOLE LOAD SCREEN IS COMPLETE NONSENSE. THIS IS THE REASON FOR THE NEW SKIP BUTTON

		//Uses timeline's. Each update adds an event consisting of changing a property that takes place after a certain period of time
		timeline = new Timeline();
		timeElapsed = 0.0f;

		update("Configuring Settings...", 0.1f, 1.5f);

		update("Saving Files to C:/Java/System/Projects...", 0.2f, 2f);

		update("Searching for Updates...", 0.3f, 2.5f);

		update("Starting Launcher...", 0.4f, 6.5f);

		//Creates a random number to 7, claims that number of dictionaries is installed
		Random random = new Random();
		int dictionaries = random.nextInt(7);

		//Separate to avoid anyone noticing links between a shown and mysterious feature
		int updateInt = random.nextInt(3);

		update("Downloaded " + dictionaries + " dictionaries...", 0.5f, 1.5f);

		if(updateInt == 2) {
			update("Update found...", 0.6f, 0.75f);

			update("Downloading update...", 0.7f, 3f);

			update("Update downloaded", 0.8f, 0.75f);

			update("Loading Completed", 0.9f, 0.75f);
		}else{
			update("No Update found", 0.6f, 0.75f);

			update("Quantifying photons...", 0.7f, 0.75f);

			update("Proving Differentiation...", 0.8f, 0.75f);

			update("Writing Nonsense", 0.9f, 0.75f);
		}
		update("Good to Go!", 1.0f, 1f);


		timeline.play();

		//Exits load sequence
		timeline.setOnFinished(e-> Main.coreProgramStart());

	}

	private void update(String text, float progress, float time){
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(time+timeElapsed), new KeyValue(label.textProperty(), text)));
		timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(time+timeElapsed), new KeyValue(bar.progressProperty(), progress)));
		timeElapsed = time + timeElapsed;

	}
	public void skip(){
		timeline.stop();

		Main.coreProgramStart();

	}
}
