package jOSeph_4.resources.controllers.core;

import jOSeph_4.games.menu.NoughtsAndCrossesMenu;
import jOSeph_4.messageBoxes.sourceFiles.Error;
import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.core.*;
import jOSeph_4.core.newOption.New;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
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
	private NoughtsAndCrossesMenu NaC;

	private static Core_Controller thisObject;

	//Can't easily auto-update - please keep updated
	final int noOfButtons = 10;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		thisObject = this;

		//Creates corePane object's
		generator = new Generator();
		quiz = new Quiz();
		calculator = new Calculator();
		newObject = new New();
		settings = new Settings();
		achievements_menu = new Achievements_Menu();
		notes = new Notes();
		messaging = new Messaging();
		Image OX_image = new Image("jOSeph_4/resources/images/game/N&C.png");
		NaC = new NoughtsAndCrossesMenu(OX_image);

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

	/**
	 * Set's the main part of the pane, calling the getPane method in a given CorePane
	 * @param type To call getPane on
	 */
	public void setMainPane(CorePane type){
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
	@FXML public void onNoughtsAndCrossesMenuClick(){
		setMainPane(NaC);
	}

	/**
	 * To exit the whole application
	 */
	public void exit(){
		closeThread();
		Main.quit();
	}

	/**
	 * Closes the thread to set size
	 */
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
