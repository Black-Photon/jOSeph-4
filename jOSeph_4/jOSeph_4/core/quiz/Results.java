package jOSeph_4.core.quiz;

import jOSeph_4.Main;
import jOSeph_4.resources.controllers.quiz.Question_Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Results {

	private Scene scene;

	public void createWindow(){
		Parent root = null;
		FXMLLoader fxmlLoader = new FXMLLoader();
		try {
			root = fxmlLoader.load(getClass().getResource("../../resources/fxml/quiz/Results.fxml"));
		}catch(Exception e){
			System.out.println("Root could not be set D:");
			e.printStackTrace();

		}
		scene = new Scene(root);
		Main.getVars().getWindow().setScene(scene);
		Main.getVars().getWindow().setTitle("Results");




	}
}
