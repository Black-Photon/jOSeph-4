package jOSeph_4;

import jOSeph_4.resources.controllers.Launcher_Controller;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Launcher {

	private Scene scene;

	/* This method creates a new launcher by referencing FXML file
	 *
	 *
	 *
	 */

	public Launcher() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Launcher.fxml"));
		scene = new Scene(root);
	}

	//Setters and Getters

	public Scene getScene() {
		return scene;
	}
}
