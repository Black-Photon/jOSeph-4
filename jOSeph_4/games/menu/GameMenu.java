package jOSeph_4.games.menu;

import jOSeph_4.core.CorePane;
import jOSeph_4.games.GameType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;

public abstract class GameMenu extends CorePane{

	//This Class
	private Image thisImage;
	private GameType gameType;

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
