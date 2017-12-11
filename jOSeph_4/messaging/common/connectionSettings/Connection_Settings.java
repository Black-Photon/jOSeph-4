package jOSeph_4.messaging.common.connectionSettings;

import jOSeph_4.messaging.common.Connection_Data;
import jOSeph_4.messaging.common.Sides;
import jOSeph_4.messaging.common.Start;
import jOSeph_4.messageBoxes.sourceFiles.messageBoxes;

import java.util.ArrayList;

public class Connection_Settings extends messageBoxes {
	//VARIABLES --------------------------------------------------------------------------------------------------------

	//Global Variables
	private ArrayList<Object> data;
	private Connection_Data defaultData;



	//METHODS ----------------------------------------------------------------------------------------------------------

	//Constructors
	public Connection_Settings(){
		super("", 500, "Connection Settings", "Connection Settings", "");
	}

	//Useful Methods
	/**
	 * Creates a window and returns it's data
	 * @return Data given by the message. The first element indicates if it was successful - True means successful
	 */
	public ArrayList<Object> createResponseBox(){
		String startLocation = "jOSeph_4/messaging/resources/fxml/";

		//Get's data
		if(Start.getSide()== Sides.CLIENT)
			fileName = startLocation + "Connection_Settings.fxml";
		else
		if(Start.getSide()==Sides.SERVER)
			fileName = startLocation + "Connection_Server_Settings.fxml";
		showModalWindowElsewhere();

		//Analyses data
		if(data==null){
			data = new ArrayList<>();
			data.add(false);
		}
		return data;
	}
	/**
	 * Creates a window with given data and returns it's data
	 * @param connection Default data to use in the message
	 * @return Data given by the message
	 */
	public ArrayList<Object> createResponseBox(Connection_Data connection){
		defaultData = connection;
		return createResponseBox();
	}

	//Getters and Setters
	ArrayList<Object> getData() {
		return data;
	}
	void setData(ArrayList<Object> data) {
		this.data = data;
	}
	Connection_Data getDefaultData() {
		return defaultData;
	}
	void setDefaultData(Connection_Data defaultData) {
		this.defaultData = defaultData;
	}
}
