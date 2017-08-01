package jOSeph_4;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Core {

	private Scene scene;

	public Core(){

	}
	public void start() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Core.fxml"));
		scene = new Scene(root);
		Main.getVars().getWindow().setTitle("Page 1");
		Main.getVars().getWindow().setScene(scene);
	}
}
