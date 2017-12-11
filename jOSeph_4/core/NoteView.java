package jOSeph_4.core;

import jOSeph_4.resources.controllers.core.NoteView_Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class NoteView{
	private static Stage stage;

	public void createNoteView(File file) throws IOException{
		NoteView_Controller.setFile(file);
		BorderPane root = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/core/NoteView.fxml"));
		stage = new Stage();
		stage.setScene(new Scene(root));
		stage.setTitle(file.getName());
		stage.show();
	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		NoteView.stage = stage;
	}
}
