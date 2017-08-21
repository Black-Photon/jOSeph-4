package jOSeph_4.resources.controllers;

import jOSeph_4.Encryption;
import jOSeph_4.Main;
import jOSeph_4.Error;
import jOSeph_4.Variable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Logon_Controller {

	@FXML
	TextField username;
	@FXML
	TextField password;

	public void onLogon() throws IOException {
		String userText = username.getText();
		String passText = password.getText();
		passText = Encryption.hashEncrypt(passText);

		//TODO Temp Admin shortcut for development. Remove in finished app
		if(username.getText().equals("a")){
			Main.startLoad();
		}else
		//End Temp Section


		if(Variable.getDatabase().get(userText)==null){
			new Error("Please enter valid username",400);

			//If database password = password, start loading
		}else if(userText.equals("")){
			//If username empty, give relevant error message
			new Error("Please enter username",400);

			//If database password = password, start loading
		}else if(Variable.getDatabase().get(userText).equals(passText)){
			Variable.setUser(username.getText());
			System.out.println("User: "+Variable.getUser());
			Main.startLoad();

			//If password empty, give relevant error message
		}else if(passText.equals("")){
			new Error("Please Enter Password",300);

			//For Wrong Password this is what's given out
		}else if(!(Variable.getDatabase().get(userText).equals(passText))){
			new Error("Your password seems to be incorrect",400);
		}else{
			new Error("Something went wrong! Please contact admin. Error #0001",500);
		}
	}
}
