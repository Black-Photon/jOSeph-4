package jOSeph_4.core;

import jOSeph_4.messaging.Client;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Messaging_Window extends CorePane {
	public Messaging_Window(Connection_Data data){
		Client.close();
		Client.setData(data);
	}

	@Override
	public Pane getPane() throws IOException {
		return super.getPane("../../../messaging/resources/fxml/Client.fxml");
	}
}
