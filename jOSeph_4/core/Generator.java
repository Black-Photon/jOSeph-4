package jOSeph_4.core;

import javafx.scene.layout.Pane;
import java.io.IOException;

public class Generator extends CorePane{
	public Pane getPane() throws IOException {
		return super.getPane("Generator.fxml");
	}
}
