package jOSeph_4.games.main;

import jOSeph_4.games.GameType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Chess extends Game {
	public Chess() {
		super(GameType.CHESS, "White", "Black", new Image("jOSeph_4/resources/images/game/noughts.png"), new Image("jOSeph_4/resources/images/game/crosses.png"));
	}

	Pane getGame(Game_Controller controller) throws IOException{
		return super.getGame(controller, "Chess.fxml");
	}
}
