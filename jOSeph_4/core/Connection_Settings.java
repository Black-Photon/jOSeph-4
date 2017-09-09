package jOSeph_4.core;

import jOSeph_4.Main;
import jOSeph_4.messageBoxes.Error;
import jOSeph_4.messageBoxes.messageBoxes;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Connection_Settings extends messageBoxes {
	private ArrayList<Object> data;
	private static Connection_Settings currentObject;

	public Connection_Settings(){
		currentObject = this;
	}

	public ArrayList<Object> createWindow(){
		stage = new Stage();
		Main.createWindow("core/Connection_Settings.fxml", stage, "Connection Settings");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();

		if(data==null){
			data = new ArrayList<>();
			data.add(false);
		}
		return data;
	}

	public ArrayList<Object> getData() {
		return data;
	}

	public void setData(ArrayList<Object> data) {
		this.data = data;
	}

	public static Connection_Settings getCurrentObject() {
		return currentObject;
	}
}
