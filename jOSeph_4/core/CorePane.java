package jOSeph_4.core;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public abstract class CorePane implements CorePaneInterface{
	public Pane getPane(String name) throws IOException {
		StackPane stackPane = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/core/"+name));
		stackPane.setAlignment(Pos.CENTER);
		return stackPane;
	}
}