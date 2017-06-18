package jOSeph_4;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Logon {

	private GridPane gridPane;
	private Label l_login;
	private Label l_username;
	private Label l_password;
	private TextField t_username;
	private TextField t_password;
	private Button b_login;
	private Scene scene;

	/* Object creates a new login scene and sets as current scene
	 *
	 *
	 */

	public Logon(){

		//Setting up

		gridPane = new GridPane();
		gridPane.setPadding(Main.getVars().getDefaultInsets());
		gridPane.setHgap(10);
		gridPane.setVgap(8);

		l_login = new Label("Login here with your username and password");
		l_password = new Label("Password:");
		l_username = new Label("Username:");
		t_password = new TextField();
		t_username = new TextField();
		b_login = new Button("Login");

		t_username.setPromptText("Username");
		t_password.setPromptText("Password");

		b_login.setOnAction(e -> {

			//TODO Temp Admin shortcut for development. Remove in finished app
			if(t_username.getText().equals("a")){
				Load.loadController();
			}else
			//End Temp Section



			//If username empty, give relevant error message
			if(Main.getVars().getDatabase().get(t_username.getText())==null){
				Error error = new Error("Error",300);
				error.setLabel("Please enter username");

				//If database password = password, start loading
			}else if(Main.getVars().getDatabase().get(t_username.getText()).equals(t_password.getText().toUpperCase())){
				Load.loadController();

				//If password empty, give relevant error message
			}else if(t_password.getText().equals("")){
				Error error = new Error("Error",300);
				error.setLabel("Please Enter Password");

				//For Wrong Password this is what's given out
			}else if(!(Main.getVars().getDatabase().get(t_username.getText()).equals(t_password.getText().toUpperCase()))){
				Error error = new Error("Error",400);
				error.setLabel("Your password seems to be incorrect");
			}else{
				Error error = new Error("Error",500);
				error.setLabel("Something went wrong! Please contact admin");
			}
		});

		Main.getVars().getWindow().setTitle("Login");

		b_login.setId("green");

		GridPane.setConstraints(l_login, 0,0,3,1);
		GridPane.setConstraints(l_username, 0,1);
		GridPane.setConstraints(l_password, 0,2);
		GridPane.setConstraints(t_username, 1,1);
		GridPane.setConstraints(t_password, 1,2);
		GridPane.setConstraints(b_login, 1,3);

		gridPane.getChildren().addAll(l_login,l_password,l_username,b_login,t_password,t_username);

		scene = new Scene(gridPane, 350,150);
		scene.getStylesheets().add("jOSeph_4/resources/css/main.css");


		Main.getVars().getWindow().setScene(scene);
	}
}
