package jOSeph_4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;



/**
 *  Creates a class to control the load scene(s)
 * BEWARE, THE WHOLE LOAD SCREEN IS COMPLETE NONSENSE. THIS IS THE REASON FOR THE NEW SKIP BUTTON
 *
 * If you solve the load screen, remember to celebrate
 * SOLVED - YAY!!!!!!
 *
 *
 */

public class Load {

	//TODO Review

	private Scene scene;

	//Basically makes and sets the scene
	public void startLoad() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Load.fxml"));
		scene = new Scene(root);
		Variable.getWindow().setScene(scene);
		Variable.getWindow().setTitle("Loading...");
	}
}









