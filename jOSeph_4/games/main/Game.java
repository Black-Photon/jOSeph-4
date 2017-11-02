package jOSeph_4.games.main;

import jOSeph_4.core.CorePane;
import jOSeph_4.games.GameType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Abstract class which handles a default interface for games
 */
public abstract class Game extends CorePane{
	private GameType gameType;

	private String player1;
	private String player2;
	private Image player1_img;
	private Image player2_img;

	/**
	 *
	 * @param gameType What game it is
	 * @param player1 Name of first player
	 * @param player2 Name of second player
	 * @param player1_img Circular image to represent the first player
	 * @param player2_img Circular image to represent the first player
	 */
	public Game(GameType gameType, String player1, String player2, Image player1_img, Image player2_img){
		this.gameType = gameType;
		this.player1 = player1;
		this.player2 = player2;
		this.player1_img = player1_img;
		this.player2_img = player2_img;
	}

	@Override
	public Pane getPane() throws IOException {
		return super.getPane("game/Main.fxml");
	}

	public GameType getGameType() {
		return gameType;
	}

	public String getPlayer1() {
		return player1;
	}

	public String getPlayer2() {
		return player2;
	}

	public Image getPlayer1_img() {
		return player1_img;
	}

	public Image getPlayer2_img() {
		return player2_img;
	}
}
