package jOSeph_4.resources.controllers;

import jOSeph_4.*;
import jOSeph_4.Error;
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

		//TODO Temp Admin shortcut for development. Remove in finished app
		if(username.getText().equals("a")){
			Variable.setUser("Guest");
			Main.startLoad();
		}else
		//End Temp Section


		if(Password.isPasswordCorrect(userText,passText)){
			Variable.setUser(userText);
			Main.startLoad();
		}
	}
}
