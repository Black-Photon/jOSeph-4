package jOSeph_4.resources.controllers;

import jOSeph_4.Password;
import jOSeph_4.Variable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Confirm_Password_Controller {

	@FXML
	TextField password;

	@FXML
	void onPressOk(){
		if(Password.isPasswordCorrect(Variable.getUser(),password.getText())){
			Password.setCorrect(true);
			Password.closeStage();
		}
	}


}
