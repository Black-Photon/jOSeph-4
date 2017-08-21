package jOSeph_4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

/**
 * Object creates a new login scene and sets as current scene
 *
 *
 */

public class Logon {

	public void start(){
		Main.createWindow("Logon.fxml", Variable.getWindow(), "Login");
	}
}
