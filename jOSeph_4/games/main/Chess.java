package jOSeph_4.games.main;

import jOSeph_4.games.GameType;
import javafx.scene.image.Image;

public class Chess extends Game {
	public Chess() {
		super(GameType.CHESS, "White", "Black", new Image("jOSeph_4/resources/images/game/noughts.png"), new Image("jOSeph_4/resources/images/game/crosses.png"));
	}
}
