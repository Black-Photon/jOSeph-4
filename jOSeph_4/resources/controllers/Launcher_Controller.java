package jOSeph_4.resources.controllers;

import jOSeph_4.Main;
import jOSeph_4.Variable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Launcher_Controller implements Initializable{
	@FXML
	Label version;

	@FXML
	public void login() throws Exception{
		Main.createWindow("Logon.fxml", Variable.getWindow(), "Login");
	}
	@FXML
	public void quit(){
		Main.quit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		version.setText(("This system is currently in version " + Variable.getVersionObject().getWholeVersion()));
	}
}
