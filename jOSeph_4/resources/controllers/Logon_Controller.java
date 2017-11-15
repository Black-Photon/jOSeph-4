package jOSeph_4.resources.controllers;

import jOSeph_4.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;


public class Logon_Controller {

	@FXML
	TextField username;
	@FXML
	TextField password;

	/**
	 * Load's if the username and password are correct
	 * @throws IOException if I/O exception happens when attempting to load
	 */
	public void onLogon() throws IOException {
		String userText = username.getText();
		String passText = password.getText();

		if(Password.isPasswordCorrect(userText,passText)){
			Variable.setUser(userText);
			Main.startLoad();
		}
	}
}
