package jOSeph_4.core.quiz;

import jOSeph_4.Main;
import jOSeph_4.resources.controllers.quiz.Feedback_Controller;
import javafx.stage.Stage;

public class Feedback {

	private static Stage stage;

	public void create(boolean isCorrect, String answer){

		Feedback_Controller.preInitialize(isCorrect, answer);

		stage = new Stage();

		Main.createWindow("quiz/Feedback.fxml", stage, "Quiz Feedback");
		if(isCorrect){
			stage.setTitle("Correct");
		}else{
			stage.setTitle("Incorrect");
		}
		stage.show();
	}

	public static void closeStage(){
		stage.close();
	}
}
