package jOSeph_4.messaging;

import jOSeph_4.messaging.Main;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class MainClient extends Application{
	/**
	 * Starts Client for messaging
	 */
	public static void main(String[] args){
		Application.launch();
	}

	/**
	 * Creates a ClientSide window and messaging application
	 * @param primaryStage Stage to display in
	 * @throws IOException To account for loading the .fxml file
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {
		new Main().start(primaryStage, "resources/fxml/Client.fxml");
	}
}