package jOSeph_4.resources.controllers.core;

import jOSeph_4.Error;
import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.core.*;
import jOSeph_4.core.newOption.New;
import jOSeph_4.resources.controllers.Achievement_Controller;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Core_Controller implements Initializable{
	@FXML
	VBox vbox;
	@FXML
	Rectangle rect;
	@FXML
	StackPane stackPane;

	private static volatile Thread thread;

	private Generator generator;
	private Quiz quiz;
	private Calculator calculator;
	private New newObject;
	private Settings settings;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Achievement_Controller.createGeneratorAchievements();

		generator = new Generator();
		quiz = new Quiz();
		calculator = new Calculator();
		newObject = new New();
		settings = new Settings();

		Color color = new Color(0.1569, 0.1569, 0.1569, 1);

		rect.setFill(color);
		rect.setStroke(color);

		//Basically keeps the left section the right size color ect. depending on window resize
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

		onGenMenuClick();
	}

	private void setMainPane(CorePane type){
		if(type instanceof Quiz){
			stackPane.getStylesheets().add("jOSeph_4/resources/css/core/new.css");
		}else{
			stackPane.getStylesheets().remove("jOSeph_4/resources/css/core/new.css");
		}
		try {
			stackPane.getChildren().remove(0,stackPane.getChildren().size());
			stackPane.getChildren().add(type.getPane());
		}catch (IOException e){
			new Error("Error #0008: IOException at Core_Controller.java");
			e.printStackTrace();
		}
	}

	public void onGenMenuClick(){
		setMainPane(generator);
	}
	public void onQuizMenuClick(){
		setMainPane(quiz);
	}
	public void onCalcMenuClick(){
		setMainPane(calculator);
	}
	public void onNewMenuClick(){
		setMainPane(newObject);
	}
	public void onSettingsMenuClick(){
		setMainPane(settings);
	}
	public void exit(){
		closeThread();
		Main.quit();
	}
	public static void closeThread(){
		Variable.getWindow().setOnCloseRequest(e->{
			Main.quit();
			e.consume();
		});
		thread = null;
	}
}
