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

public class Password {
		public static boolean correct;
		public static String name;
	
		public static void password(String default_user,HashMap<?, ?> database){
			Stage window = new Stage();
			correct = false;
			
			window.setTitle("Login");
			window.setOnCloseRequest(e -> {Generator4.off();});
			window.initModality(Modality.APPLICATION_MODAL);
			
			GridPane gridpane = new GridPane();
			gridpane.setPadding(new Insets(10,10,10,10));
			gridpane.setVgap(8);
			gridpane.setHgap(10);
			
			Label nameLabel = new Label("Username: ");
			GridPane.setConstraints(nameLabel, 0, 0);
			TextField nameInput = new TextField(default_user);
			nameInput.setPromptText("Enter Username");
			GridPane.setConstraints(nameInput, 1, 0);
			
			Label passLabel = new Label("Password: ");
			GridPane.setConstraints(passLabel, 0, 1);
			TextField passInput = new TextField("");
			passInput.setPromptText("Enter Password");
			GridPane.setConstraints(passInput, 1, 1);
			
			Button login = new Button("Log In");
			GridPane.setConstraints(login, 1, 3);
			
			gridpane.getChildren().addAll(nameLabel,nameInput,passLabel,passInput,login);

			
			window.setScene(new Scene(gridpane));
			window.show();
			
			
			//Checks if password is correct, and proceeds if it is.
			
			login.setOnAction(e -> {
			
			if(database.get(nameInput.getText()) == null){
				AlertBox_GUI.display("No Such Username", "Unfortunatly, this username was not found in our database", "Try Again", 400);
			}
			
			
			if(database.get(nameInput.getText()).equals(passInput.getText())){
				correct = true;
				final String name = nameInput.getText();
				window.close();
				try {
					Thread.sleep(2000);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Generator4.userStore(name);
			}else{
				AlertBox_GUI.display("Incorrect Password", "Incorrect Username or Password - Try Again", "Try Again", 400);
				
			}
			
			
			
			});
		}
}


















