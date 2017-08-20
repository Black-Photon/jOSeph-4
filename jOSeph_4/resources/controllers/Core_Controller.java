package jOSeph_4.resources.controllers;

import jOSeph_4.Core;
import jOSeph_4.Main;
import jOSeph_4.core.Calculator;
import jOSeph_4.core.quiz.Quiz;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
	@FXML
	Pane calculatorPane;

	private static int countInt = 0;
	private static double progress;
	private ArrayList<Pane> panes;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		count.setText(Integer.toString(countInt));

		Achievement_Controller.createGeneratorAchievements();

		Calculator calculator = new Calculator();
		try {
			calculatorPane.getChildren().add(calculator.getCalculator());
		}catch (IOException e){
			e.printStackTrace();
		}


		panes = new ArrayList<Pane>();
		panes.add(genPane);
		panes.add(quizPane);
		panes.add(calculatorPane);


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
		for(Pane i: panes){
			i.setVisible(false);
		}
	}

	public void onGenMenuClick(){
		hideAllPanes();
		genPane.setVisible(true);
	}
	public void onQuizMenuClick(){
		hideAllPanes();
		quizPane.setVisible(true);
	}
	public void onCalcMenuClick(){
		hideAllPanes();
		calculatorPane.setVisible(true);
	}
	public void exit(){
		Main.quit();
	}
}
