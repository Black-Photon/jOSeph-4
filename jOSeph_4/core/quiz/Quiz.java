package jOSeph_4.core.quiz;

import jOSeph_4.Variable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Quiz {

	private Scene scene;

	public void startMenu() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/quiz/Quiz.fxml"));
		scene = new Scene(root);
		Variable.getWindow().setTitle("Quiz");
		Variable.getWindow().setScene(scene);
	}
}
