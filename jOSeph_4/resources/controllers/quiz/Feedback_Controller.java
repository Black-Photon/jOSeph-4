package jOSeph_4.resources.controllers.quiz;

import jOSeph_4.core.quiz.Feedback;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Feedback_Controller implements Initializable{
	@FXML
	Label correctLabel;
	@FXML
	Label correctFinal;
	@FXML
	Label answerLabel;
	@FXML
	Button button;

	public void nextQuestion(){
		Feedback.closeStage();
		Question_Controller q = new Question_Controller();
		q.getSubject().nextQuestion(q.getThisQuestion(), q.getSubject());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		correctLabel.setText(correctLabelString);
		answerLabel.setText(answerLabelString);
		if(correct){
			correctFinal.setVisible(false);
			answerLabel.setVisible(false);
			button.setId("green");
		}else{
			button.setId("red");
		}
	}

	private static String correctLabelString;
	private static String answerLabelString;
	private static boolean correct;


	public static void preinitalize(boolean correct, String answer){
		if(correct){
			correctLabelString = "Correct";
		}else{
			correctLabelString = "Incorrect";
		}
		answerLabelString = answer;
		Feedback_Controller.correct = correct;
	}
}
