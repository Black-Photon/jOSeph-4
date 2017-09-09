package jOSeph_4.core;

import jOSeph_4.core.newOption.Tabs;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;

public class Notes extends CorePane {
	@Override
	public Pane getPane() throws IOException {
		StackPane pane = new StackPane();
		pane.getChildren().add(getNotes());
		return pane;
	}
	private BorderPane getNotes() throws IOException {
		BorderPane root = FXMLLoader.load(getClass().getResource("../resources/fxml/core/Notes.fxml"));
		return root;
	}
}
