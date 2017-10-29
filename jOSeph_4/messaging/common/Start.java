package jOSeph_4.messaging.common;

import jOSeph_4.Variable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Acts as a controller for the main messaging start page
 */
public class Start implements Initializable {
	//VARIABLES --------------------------------------------------------------------------------------------------------

	//Global Variables
	private static Sides side;
	private static String username;

	//FXML
	@FXML private Label name;



	//METHODS ----------------------------------------------------------------------------------------------------------

	//Initialization
	@Override public void initialize(URL location, ResourceBundle resources) {
		//Get existing name. If no existing name, make one called CLIENT
		username = Variable.getUser();
		name.setText(username);
	}

	//User Input
	@FXML void onClientPressed() {
		side = Sides.CLIENT;
		Main.createWindow("Messaging.fxml", Variable.getWindow(), "Messaging");
	}
	@FXML void onServerPressed() {
		side = Sides.SERVER;
		Main.createWindow("Messaging.fxml", Variable.getWindow(), "Messaging");
	}

	//Getters and Setters
	public static Sides getSide() {
		return side;
	}
	public static void setSide(Sides side) {
		Start.side = side;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Start.username = username;
	}
}
