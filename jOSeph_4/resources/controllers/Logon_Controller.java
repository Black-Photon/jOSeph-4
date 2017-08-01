package jOSeph_4.resources.controllers;

import jOSeph_4.Main;
import jOSeph_4.Error;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class Logon_Controller {
	@FXML
	TextField t_username;
	@FXML
	TextField t_password;




	public void onLogon() throws Exception{
		//TODO Temp Admin shortcut for development. Remove in finished app
		if(t_username.getText().equals("a")){
			Main.startLoad();
		}else
			//End Temp Section



			//If username empty, give relevant error message
			if(Main.getVars().getDatabase().get(t_username.getText())==null){
				Error error = new Error("Error",300);
				error.setLabel("Please enter valid username");

				//If database password = password, start loading
			}else if(Main.getVars().getDatabase().get(t_username.getText()).equals(t_password.getText().toUpperCase())){
				Main.getVars().setUser(t_username.getText());
				System.out.println("User: "+Main.getVars().getUser());
				Main.startLoad();

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
				error.setLabel("Something went wrong! Please contact admin. Error #0001");
			}
	}
}
