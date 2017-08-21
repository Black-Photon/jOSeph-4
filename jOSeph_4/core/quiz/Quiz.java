package jOSeph_4.core.quiz;

import jOSeph_4.Main;
import jOSeph_4.Variable;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Quiz {

	private Scene scene;

	public void startMenu(){
		Main.createWindow("quiz/Quiz.fxml",Variable.getWindow(),"Quiz");
	}
}
