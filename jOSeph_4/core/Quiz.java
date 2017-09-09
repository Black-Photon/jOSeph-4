package jOSeph_4.core;

import javafx.scene.layout.Pane;

import java.io.IOException;

public class Quiz extends CorePane{
	public Pane getPane() throws IOException {
		return super.getPane("QuizMenu.fxml");
	}
}
