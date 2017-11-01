package jOSeph_4.games;

import jOSeph_4.core.CorePane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class Game extends CorePane{
	@Override
	public Pane getPane() throws IOException {
		return super.getPane("game/Menu.fxml");
	}
}
