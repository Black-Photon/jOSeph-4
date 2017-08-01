package jOSeph_4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Logon {

	private GridPane gridPane;
	private Label l_login;
	private Label l_username;
	private Label l_password;
	private TextField t_username;
	private TextField t_password;
	private Button b_login;
	private Scene scene;

	/* Object creates a new login scene and sets as current scene
	 *
	 *
	 */

	public Logon() throws Exception{

		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Logon.fxml"));
		scene = new Scene(root);
		Main.getVars().getWindow().setTitle("Login");
		Main.getVars().getWindow().setScene(scene);
	}
}
