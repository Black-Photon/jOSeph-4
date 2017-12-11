package jOSeph_4.core;

import javafx.fxml.FXMLLoader;
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

	/**
	 * Get's the notes BorderPane default menu
	 * @return The borderpane
	 * @throws IOException
	 */
	private BorderPane getNotes() throws IOException {
		BorderPane root = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/core/Notes.fxml"));
		return root;
	}
}
