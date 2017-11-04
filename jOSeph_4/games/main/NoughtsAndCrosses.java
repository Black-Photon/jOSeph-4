package jOSeph_4.games.main;

import jOSeph_4.games.GameType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class NoughtsAndCrosses extends Game {
	public NoughtsAndCrosses(){
		super(GameType.NOUGHTSANDCROSSES, "Noughts", "Crosses", new Image("jOSeph_4/resources/images/game/noughts.png"), new Image("jOSeph_4/resources/images/game/crosses.png"));
	}

	Pane getGame(Game_Controller controller) throws IOException{
		return super.getGame(controller, "NoughtsAndCrosses.fxml");
	}
}
