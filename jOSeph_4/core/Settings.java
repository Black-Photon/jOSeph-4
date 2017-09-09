package jOSeph_4.core;

import javafx.scene.layout.Pane;

import java.io.IOException;

public class Settings extends CorePane{
	@Override
	public Pane getPane() throws IOException {
		return super.getPane("Settings.fxml");
	}
	//TODO check if spaces work
}
