package jOSeph_4.resources.controllers;

import jOSeph_4.Core;
import jOSeph_4.Main;
import jOSeph_4.core.quiz.Quiz;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Core_Controller implements Initializable{
	@FXML
	ProgressBar bar;
	@FXML
	Label count;
	@FXML
	Pane genPane;
	@FXML
	Pane quizPane;

	private static int countInt = 0;
	private static double progress;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		count.setText(Integer.toString(countInt));

		Achievement_Controller.createGeneratorAchievements();
	}

	public void onGeneratorClick(){
		int x = countInt;


		Random random = new Random();
		double randomDouble = (double)(random.nextInt(5))/10.0;
		progress += randomDouble;
		if(progress>=1){
			progress-=1;
			countInt++;
		}
		bar.setProgress(progress);
		count.setText(Integer.toString(countInt));

		boolean changed = true;
		if(countInt==x){
			changed = false;
		}
		if(changed){
			//TODO make message interface

			//*
			try {
				Achievement_Controller.onLevelUp(countInt);
			}catch (IOException e){
				e.printStackTrace();
			}//*/

		}
	}

	public void onQuizStartPressed(){
		Core.startQuiz();
	}

	public void hideAllPanes(){
		genPane.setVisible(false);
		quizPane.setVisible(false);
	}

	public void onGenMenuClick(){
		hideAllPanes();
		genPane.setVisible(true);
	}
	public void onQuizMenuClick(){
		hideAllPanes();
		quizPane.setVisible(true);
	}
	public void exit(){
		Main.quit();
	}
}
