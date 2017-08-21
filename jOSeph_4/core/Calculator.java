package jOSeph_4.core;

import jOSeph_4.Main;
import jOSeph_4.Variable;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculator extends Application{
	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage primaryStage){
		Main.createWindow("Calculator.fxml", primaryStage, "Calculator");
		primaryStage.show();
	}

	public Pane getCalculator() throws IOException{
		Pane root = FXMLLoader.load(getClass().getResource("../resources/fxml/Calculator.fxml"));
		return root;
	}
}
