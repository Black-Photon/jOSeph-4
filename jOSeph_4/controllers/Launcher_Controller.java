package jOSeph_4.resources.controllers;

import jOSeph_4.Logon;
import jOSeph_4.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Launcher_Controller implements Initializable{
	@FXML
	Label version;

	public void login() throws Exception{
		Logon logon = new Logon();
	}
	public void quit(){
		Main.quit();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		version.setText(("This system is currently in version " + Main.getVars().getVersionObject().bToString() + " " + Main.getVars().getVersionObject().getC() + " - " + Main.getVars().getVersionObject().getA()));
	}
}
