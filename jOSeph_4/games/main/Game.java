package jOSeph_4.games.main;

import jOSeph_4.core.CorePane;
import jOSeph_4.games.GameType;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

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

	/**
	 * Creates a pane of the actual game that can be put in the template window
	 * @param controller The controller that is controlling the the template window
	 * @return The Pane
	 */
	protected Pane getGame(Game_Controller controller, String fileName) throws IOException {
		Game thisObject = this;
		ResourceBundle resources = new ResourceBundle() {
			/**
			 * Should be "this" for this object
			 * @param key What data to retrieve
			 * @return The Object relating to the key
			 */
			@Override
			protected Object handleGetObject(String key) {
				if(key.equals("this")){
					return thisObject;
				}
				if(key.equals("controller")){
					return controller;
				}
				return null;
			}

			@Override
			public Enumeration<String> getKeys() {
				Enumeration<String> enumeration = new Enumeration<String>() {
					private String[] elements = {"this", "controller"};
					private int count = 0;

					@Override
					public boolean hasMoreElements() {
						if(count<elements.length) return true;
						return false;
					}

					@Override
					public String nextElement() {
						count++;
						return elements[count-1];
					}
				};
				return enumeration;
			}
		};      //Basically contains this object and controller in a convoluted way. Supports extra info

		return getPane("game/"+fileName, resources);
	}

	abstract Pane getGame(Game_Controller controller) throws IOException;
}
