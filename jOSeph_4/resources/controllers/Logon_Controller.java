package jOSeph_4.resources.controllers;

import jOSeph_4.Encryption;
import jOSeph_4.Main;
import jOSeph_4.Error;
import jOSeph_4.Variable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Logon_Controller {

	//TODO Review Class

	@FXML
	TextField username;
	@FXML
	TextField password;

	public void onLogon() throws Exception{
		String passText = password.getText();
		passText = Encryption.hashEncrypt(passText);
		System.out.println(passText);

		//TODO Temp Admin shortcut for development. Remove in finished app
		if(username.getText().equals("a")){
			Main.startLoad();
		}else
		//End Temp Section



		//If username empty, give relevant error message
		if(Variable.getDatabase().get(username.getText())==null){
			new Error("Please enter valid username",400);

			//If database password = password, start loading
		}else if(Variable.getDatabase().get(username.getText()).equals(passText)){
			Variable.setUser(username.getText());
			System.out.println("User: "+Variable.getUser());
			Main.startLoad();

			//If password empty, give relevant error message
		}else if(passText.equals("")){
			new Error("Please Enter Password",300);

			//For Wrong Password this is what's given out
		}else if(!(Variable.getDatabase().get(username.getText()).equals(passText))){
			new Error("Your password seems to be incorrect",400);
		}else{
			new Error("Something went wrong! Please contact admin. Error #0001",500);
		}
	}
}
