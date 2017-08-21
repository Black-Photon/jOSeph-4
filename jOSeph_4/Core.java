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
	public void start(){
		Main.createWindow("Core.fxml",Variable.getWindow(),"Page 1");
	}
	public static void startQuiz(){
		new Quiz().startMenu();
	}


	public static int getGenCount() {
		return genCount;
	}

	public static void setGenCount(int genCount) {
		Core.genCount = genCount;
	}
}
