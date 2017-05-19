package questionareGui;

import java.util.HashMap;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Settings {
	public static void settings(HashMap<String, String> database, String user){
		Stage window = new Stage();
		window.setTitle("Settings");
		window.initModality(Modality.APPLICATION_MODAL);
		
		GridPane gridpane = new GridPane();
		gridpane.setPadding(new Insets(10,10,10,10));
		gridpane.setVgap(8);
		gridpane.setHgap(10);
		
		Label nameLabel = new Label("Username: ");
		GridPane.setConstraints(nameLabel, 0, 0);
		Label nameInput = new Label(user);
		GridPane.setConstraints(nameInput, 1, 0);
		
		
		Label passLabel = new Label("Password: ");
		GridPane.setConstraints(passLabel, 0, 1);
		TextField passInput = new TextField();
		passInput.setPromptText("Enter New Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button back = new Button("Done");
		GridPane.setConstraints(back, 1, 3);
		
		gridpane.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,back);

		
		window.setScene(new Scene(gridpane));
		window.show();
		
		
		
		
		back.setOnAction(e -> {
			database.put(user, passInput.getText());
			System.out.println(database);
			
			CreateSettings.load(true, database);
			
			
			AlertBox_GUI.display("Saved", "Sucessfully Saved", "OK", 200);
		});
	}}























