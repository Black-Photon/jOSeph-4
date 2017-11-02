package jOSeph_4.resources.controllers.core;

import jOSeph_4.Version;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class New_Controller implements Initializable{
	private static Version version;
	private static String info;
	public static void preInitialize(Version version, String info){
		New_Controller.version = version;
		New_Controller.info = info;
	}

	@FXML
	Label versionInfo;
	@FXML
	TextArea textArea;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		versionInfo.setText("jOSeph Version: " + version.versionToString() + " " + version.getRelease());
		textArea.setText(info);
	}
}
