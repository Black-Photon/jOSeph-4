package jOSeph_4.messageBoxes.resources.controllers;

import jOSeph_4.messageBoxes.ConfirmBox;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfirmBox_Controller implements Initializable{
	@FXML
	private Label title;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		title.setText(ConfirmBox.getCurrentObject().getText());
	}

	@FXML
	void onPressNo() {
		ConfirmBox.getCurrentObject().setYes(false);
		ConfirmBox.getCurrentObject().exit();
	}

	@FXML
	void onPressYes() {
		ConfirmBox.getCurrentObject().setYes(true);
		ConfirmBox.getCurrentObject().exit();
	}

}
