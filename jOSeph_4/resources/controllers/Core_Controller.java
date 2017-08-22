package jOSeph_4.resources.controllers;

import jOSeph_4.Core;
import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.core.Calculator;
import jOSeph_4.core.newOption.New;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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
	@FXML
	Pane newPane;
	@FXML
	Pane settingsPane;
	@FXML
	VBox vbox;
	@FXML
	Rectangle rect;

	private static int countInt = 0;
	private static double progress;
	private ArrayList<Pane> panes;
	private volatile Thread thread;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		count.setText(Integer.toString(countInt));

		Achievement_Controller.createGeneratorAchievements();

		Calculator calculator = new Calculator();
		New newObject = new New();
		try {
			calculatorPane.getChildren().add(calculator.getCalculator());
			newPane.getChildren().add(newObject.getNew());
		}catch (IOException e){
			e.printStackTrace();
		}


		panes = new ArrayList<Pane>();
		panes.add(genPane);
		panes.add(quizPane);
		panes.add(calculatorPane);
		panes.add(newPane);

		Color color = new Color(0.1569, 0.1569, 0.1569, 1);

		rect.setFill(color);
		rect.setStroke(color);

		thread = new Thread(new Task() {
			private double height;

			@Override
			protected Object call() throws Exception {
				return null;
			}
			@Override
			public void run(){
				final int size1 = 96;
				final int size2 = 80;
				final int noOfButtons = 7;
				final int heightBreakpoint = noOfButtons * 76;
				while(thread == Thread.currentThread()){
					height = Variable.getWindow().getHeight();
					if(height>=heightBreakpoint){
						vbox.setMinWidth(size1);
						vbox.setPrefWidth(size1);
						vbox.setMaxWidth(size1);
						rect.setWidth(size1);
					}else{
						vbox.setMinWidth(size2);
						vbox.setPrefWidth(size2);
						vbox.setMaxWidth(size2);
						rect.setWidth(size2);
					}
					rect.setHeight(height-heightBreakpoint);
				}
			}
		});
		thread.start();
		Variable.getWindow().setOnCloseRequest(e->{
			thread = null;
			Main.quit();
			e.consume();
		});
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
		closeThread();
		Core.startQuiz();
	}

	private void hideAllPanes(){
		closeThread();
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
	public void onNewMenuClick(){
		hideAllPanes();
		newPane.setVisible(true);
	}
	public void onSettingsMenuClick(){
		hideAllPanes();
		settingsPane.setVisible(true);
	}
	public void exit(){
		closeThread();
		Main.quit();
	}
	private void closeThread(){
		Variable.getWindow().setOnCloseRequest(e->{
			Main.quit();
			e.consume();
		});
		thread = null;
	}
}
