package jOSeph_4.core;

import javafx.scene.layout.Pane;

import java.io.IOException;

public class Calculator extends CorePane{
	@Override
	public Pane getPane() throws IOException{
		return super.getPane("Calculator.fxml");
	}
}
