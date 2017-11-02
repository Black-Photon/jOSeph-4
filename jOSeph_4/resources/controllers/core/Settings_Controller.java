package jOSeph_4.resources.controllers.core;

import jOSeph_4.Encryption;
import jOSeph_4.messageBoxes.sourceFiles.Error;
import jOSeph_4.Password;
import jOSeph_4.Variable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class Settings_Controller implements Initializable{
	@FXML
	TextField username;
	@FXML
	TextField password;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		username.setText(Variable.getUser());
	}

	@FXML
	void onPressClear(){
		username.setText(Variable.getUser());
		password.setText("");
	}
	@FXML
	void onPressOk(){
		if(usernameChanged()) {
			for (String key : Variable.getDatabase().keySet()) {
				if (!key.equals(Variable.getUser())) {
					if (key.equals(username.getText())) {
						new Error("Can't change username to existing username", 500).showModalWindow();
						return;
					}
				}
			}
		}


		HashMap database = Variable.getDatabase();
		if(adminSettingChanged()){
			Password.createConfirmBox();
			if(Password.isCorrect()) {
				if (usernameChanged() && passwordChanged()) {
					System.out.println(database);
					database.remove(Variable.getUser());
					database.put(username.getText(), Encryption.hashEncrypt(password.getText()));
					System.out.println(database);
					Variable.setUser(username.getText());
				} else if (usernameChanged()) {
					System.out.println(database);
					database.put(username.getText(), database.remove(Variable.getUser()));
					System.out.println(database);
					Variable.setUser(username.getText());
				} else if (passwordChanged()) {
					System.out.println(database);
					database.put(Variable.getUser(), Encryption.hashEncrypt(password.getText()));
					System.out.println(database);
				} else {
					new Error("Error #0008: Logic error at Settings_Controller.java", 600).showModalWindow();
				}
				Password.setCorrect(false);
				try {
					Variable.getConfigFiles().loadAndWriteConfig(Variable.getDatabase());
				} catch (IOException e) {
					new Error("Error #0009: IOException at Settings_Controller.java", 500).showModalWindow();
					e.printStackTrace();
				}
			}
		}
	}

	private boolean adminSettingChanged(){
		return usernameChanged() || passwordChanged();
	}
	private boolean usernameChanged(){
		return !username.getText().equals(Variable.getUser());
	}
	private boolean passwordChanged(){
		return !password.getText().equals("");
	}
}
