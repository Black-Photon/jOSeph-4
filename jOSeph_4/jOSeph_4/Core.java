package jOSeph_4;

import jOSeph_4.core.quiz.Quiz;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Core {

	private Scene scene;
	private static int genCount;

	public Core(){

	}
	public void start() throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("resources/fxml/Core.fxml"));
		scene = new Scene(root);
		Main.getVars().getWindow().setTitle("Page 1");
		Main.getVars().getWindow().setScene(scene);
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
