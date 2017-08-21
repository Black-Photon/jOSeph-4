package jOSeph_4;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Creates and shows an error message of chosen Message, width and title
 */

public class Error {

	private Label label;
	private Image image;
	private ImageView imageView;
	private Scene scene;
	private Stage stage;
	private Button ok;
	private double width;
	private String text;

	private static Error currentObject;

	public Error() {
		this("Error");
	}

	public Error(String text){
		this(text, 400);
	}

	public Error(String text, int width){
		this(text, width, "Error");
	}

	public Error(String text, int width, String title){
		this.width = width;
		this.text = text;
		currentObject = this;

		stage = new Stage();
		Main.createWindow("Error.fxml", stage, title);
	}

	public static Error getCurrentObject() {
		return currentObject;
	}

	public double getWidth() {
		return width;
	}

	public String getText() {
		return text;
	}

	public void exit(){
		stage.close();
	}
}
