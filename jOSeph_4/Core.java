package jOSeph_4;

import jOSeph_4.core.quiz.Quiz;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public class Core {

	private Scene scene;
	private static int genCount;

	public Core(){

	}
	public void start() throws IOException{
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Core.fxml"));
		scene = new Scene(root);
		Variable.getWindow().setTitle("Page 1");
		Variable.getWindow().setScene(scene);
	}
	public static void startQuiz(){
		try{
			new Quiz().startMenu();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public static int getGenCount() {
		return genCount;
	}

	public static void setGenCount(int genCount) {
		Core.genCount = genCount;
	}
}
