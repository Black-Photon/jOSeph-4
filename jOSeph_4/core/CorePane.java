package jOSeph_4.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class CorePane implements CorePaneInterface{
	public Pane getPane(String name) throws IOException {
		Pane root = FXMLLoader.load(getClass().getClassLoader().getResource("jOSeph_4/resources/fxml/core/"+name));
		return root;
	}
}