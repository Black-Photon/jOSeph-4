package jOSeph_4.core.quiz;

import jOSeph_4.Main;
import jOSeph_4.resources.controllers.quiz.Feedback_Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Feedback {

	private static Scene scene;
	private static Stage stage;

	public void create(boolean isCorrect, String answer){

		Feedback_Controller.preinitalize(isCorrect, answer);

		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			root = fxmlLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/quiz/Feedback.fxml"));
		}catch(Exception e){
			System.out.println("Root could not be set D:");
			e.printStackTrace();
		}
		scene = new Scene(root);
		stage = new Stage();
		stage.setScene(scene);
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
