package jOSeph_4.resources.controllers.core;

import jOSeph_4.core.Connection_Settings;
import jOSeph_4.messageBoxes.Error;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Connection_Settings_Controller implements Initializable{

	@FXML
	private TextField nameBox;

	@FXML
	private TextField ip1Box;

	@FXML
	private TextField ip2Box;

	@FXML
	private TextField ip3Box;

	@FXML
	private TextField ip4Box;

	@FXML
	private TextField ipPortBox;

	private ArrayList<TextField> ipArray;
	private ArrayList<Integer> limits;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ipArray = new ArrayList<>();
		limits = new ArrayList<>();
		ipArray.add(ip1Box);
		limits.add(3);
		ipArray.add(ip2Box);
		limits.add(3);
		ipArray.add(ip3Box);
		limits.add(3);
		ipArray.add(ip4Box);
		limits.add(3);
		ipArray.add(ipPortBox);
		limits.add(5);
	}

	@FXML
	void onBackPressed() {
		returnInfo(false);
	}

	@FXML
	void onConfirmPressed() {
		if(!confirmTextSize()){
			return;
		}
		for(TextField i: ipArray){
			if(i.getText().equals("")){
				new Error("Please Enter Info");
				return;
			}
		}

		returnInfo(true);
	}

	private void returnInfo(boolean success){
		confirmText();
		ArrayList<Object> data = new ArrayList<>();
		data.add(success);
		data.add(nameBox.getText());
		ArrayList<Integer> ipNameArray = new ArrayList();
		for(TextField i: ipArray){
			ipNameArray.add(Integer.parseInt(i.getText()));
		}
		data.add(ipNameArray);
		Connection_Settings.getCurrentObject().setData(data);
		Connection_Settings.getCurrentObject().exit();
	}

	@FXML
	void confirmText(){
		for(int i = 0; i<ipArray.size(); i++){
			TextField thisField = ipArray.get(i);

			if(thisField.getText().length()>limits.get(i)){
				thisField.setText(thisField.getText(0, limits.get(i)));
			}

			try{
				int x = Integer.parseInt(thisField.getText());
			}catch (NumberFormatException e){
				int end = thisField.getLength()-1;
				if(end>=0){
					thisField.setText(thisField.getText(0, end));
				}
			}
		}
	}

	private boolean confirmTextSize(){
		for(int i = 0; i<ipArray.size();i++){
			if(ipArray.get(i).getText().length()!=limits.get(i)){
				new Error("Please fully complete all boxes",500);
				return false;
			}
		}
		return true;
	}
}
