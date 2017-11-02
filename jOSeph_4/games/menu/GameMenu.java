package jOSeph_4.games.menu;

import jOSeph_4.core.CorePane;
import jOSeph_4.games.GameType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Class to control the menu of the game. A subclass only needs to pass an image and the type of game in constructor - it handles the rest
 */
public abstract class GameMenu extends CorePane{

	//This Class
	private Image thisImage;
	private GameType gameType;

	/**
	 * @param image To appear on the menu screen
	 * @param gameType What type of game it is
	 */
	public GameMenu(Image image, GameType gameType){
		thisImage = image;
		this.gameType = gameType;
	}

	@Override
	public Pane getPane() throws IOException {
		return super.getPane("game/Menu.fxml");
	}

	public Image getThisImage() {
		return thisImage;
	}

	public GameType getGameType() {
		return gameType;
	}
}
