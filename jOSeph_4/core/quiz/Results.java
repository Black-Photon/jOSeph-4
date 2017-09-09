package jOSeph_4.core.quiz;

import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.resources.controllers.quiz.Question_Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Results {

	private Scene scene;

	public void createWindow(){
		Main.createWindow("quiz/Results.fxml", Variable.getWindow(), "Results");
	}
}
