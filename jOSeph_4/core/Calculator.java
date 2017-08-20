package jOSeph_4.core;

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
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../resources/fxml/Calculator.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setTitle("Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public Pane getCalculator() throws IOException{
		Pane root = FXMLLoader.load(getClass().getResource("../resources/fxml/Calculator.fxml"));
		return root;
	}
}
