package jOSeph_4;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.Random;



/* Creates a class to control the load scene(s)
 * BEWARE, THE WHOLE LOAD SCREEN IS COMPLETE NONSENSE. THIS IS THE REASON FOR THE NEW SKIP BUTTON
 *
 * If you solve the load screen, remember to celebrate
 * SOLVED - YAY!!!!!!
 *
 *
 */

public class Load {

	private static Scene scene;


	//Basically makes and sets the scene
	public Load() throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Load.fxml"));
		scene = new Scene(root);
		Main.getVars().getWindow().setScene(scene);
		Main.getVars().getWindow().setTitle("Loading...");
	}
}









