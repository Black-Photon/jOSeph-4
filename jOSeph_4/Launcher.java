package jOSeph_4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

class Launcher {

	/**
	 * This method creates a new launcher by referencing FXML file
	 *
	 */
	void start(){
		Main.createWindow("Launcher.fxml",Variable.getWindow(), "jOSeph " + Variable.getVersionObject().bToString());
	}

}
