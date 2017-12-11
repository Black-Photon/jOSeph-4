package jOSeph_4.core;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Messaging extends CorePane {
	@Override
	public Pane getPane() throws IOException {
		//Traditional way doesn't work for some reason, so copying from CorePane
		StackPane stackPane = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/messaging/resources/fxml/Main.fxml"));
		stackPane.setAlignment(Pos.CENTER);
		return stackPane;
	}
}
