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
	void start() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Launcher.fxml"));
		Scene scene = new Scene(root);
		Variable.getWindow().setScene(scene);
		Variable.getWindow().show();
	}

}
