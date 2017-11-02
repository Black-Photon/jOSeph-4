package jOSeph_4.games.main;

import jOSeph_4.games.GameType;
import javafx.scene.image.Image;

public class NoughtsAndCrosses extends Game {
	public NoughtsAndCrosses(){
		super(GameType.NOUGHTSANDCROSSES, "Noughts", "Crosses", new Image("jOSeph_4/resources/images/game/noughts.png"), new Image("jOSeph_4/resources/images/game/crosses.png"));
	}
}
