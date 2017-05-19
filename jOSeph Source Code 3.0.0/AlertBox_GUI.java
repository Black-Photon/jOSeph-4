package questionareGui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox_GUI {
	//This is basically to prevent the need for making one every time I need one. I would have 10000 classes!
	
	//Constructor (Or at least I think that's what it's called) for the alertbox
	public static void display(String title, String message, String BMessage, int width){
		//Creates Window
		Stage window = new Stage();
		//Stops clicking off it
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(width);
		
		//The rest sets out layout
		Label label = new Label(message);
		Button closeButton = new Button(BMessage);
		closeButton.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10,10,10,10));
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
	}
}
