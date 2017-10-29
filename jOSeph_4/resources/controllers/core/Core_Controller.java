package jOSeph_4.resources.controllers.core;

import jOSeph_4.messageBoxes.sourceFiles.Error;
import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.core.*;
import jOSeph_4.core.newOption.New;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
	private Achievements_Menu achievements_menu;
	private Notes notes;
	private Messaging messaging;

	private static Core_Controller thisObject;

	final int noOfButtons = 9;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		thisObject = this;

		generator = new Generator();
		quiz = new Quiz();
		calculator = new Calculator();
		newObject = new New();
		settings = new Settings();
		achievements_menu = new Achievements_Menu();
		notes = new Notes();
		messaging = new Messaging();

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
		/*if(type instanceof New){
			stackPane.getStylesheets().add("jOSeph_4/resources/css/core/new.css");
		}else{
			stackPane.getStylesheets().remove("jOSeph_4/resources/css/core/new.css");
		}*/
		try {
			stackPane.getChildren().remove(0,stackPane.getChildren().size());
			stackPane.getChildren().add(type.getPane());
		}catch (IOException e){
			new Error("Error #0008: IOException at Core_Controller.java").showModalWindow();
			e.printStackTrace();
		}
	}

	@FXML public void onGenMenuClick(){
		setMainPane(generator);
	}
	@FXML public void onQuizMenuClick(){
		setMainPane(quiz);
	}
	@FXML public void onCalcMenuClick(){
		setMainPane(calculator);
	}
	@FXML public void onNewMenuClick(){
		setMainPane(newObject);
	}
	@FXML public void onSettingsMenuClick(){
		setMainPane(settings);
	}
	@FXML public void onAchievementsMenuClick(){
		setMainPane(achievements_menu);
	}
	@FXML public void onNotesMenuClick(){
		setMainPane(notes);
	}
	@FXML public void onMessagingMenuClick(){
		setMainPane(messaging);
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
	public static Core_Controller getThisObject(){
		return thisObject;
	}
}
