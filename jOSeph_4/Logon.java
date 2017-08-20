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

	public void start() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Logon.fxml"));
		Scene scene = new Scene(root);
		Variable.getWindow().setTitle("Login");
		Variable.getWindow().setScene(scene);
	}
}
