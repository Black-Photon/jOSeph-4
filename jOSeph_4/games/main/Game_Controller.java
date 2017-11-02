package jOSeph_4.games.main;

import jOSeph_4.games.Player;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Controls the game outer shell. The pane should be filled with the inner game
 */
public class Game_Controller implements Initializable{

	@FXML
	private Label title;
	@FXML
	private ImageView image1;
	@FXML
	private ImageView image2;

	private Game game;
	private Player player = Player.PLAYER1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		game = (Game) resources.getObject(resources.getKeys().nextElement());
		image1.setImage(game.getPlayer1_img());
		image2.setImage(game.getPlayer2_img());
		image2.fitHeightProperty().set(20);
		setTitle();
	}

	/**
	 * Set's the title of the window to whoever's turn it is (Not stage title)
	 */
	void setTitle(){
		if(player1()){
			title.setText(game.getPlayer1()+"'s Turn");
		}else{
			title.setText(game.getPlayer2()+"'s Turn");
		}
	}
	boolean player1(){
		if(player == Player.PLAYER1){
			return true;
		}
		return false;
	}
	boolean player2(){
		if(player == Player.PLAYER2){
			return true;
		}
		return false;
	}

	/**
	 * Swaps the current player
	 */
	void swapPlayer(){
		if(player==Player.PLAYER1) player = Player.PLAYER2; else
		if(player==Player.PLAYER2) player = Player.PLAYER1;
		swapPlayerImages();
		setTitle();
	}

	/**
	 * Enlarges one image and shrinks the other
	 */
	void swapPlayerImages(){
		Timeline timeline = new Timeline();
		KeyValue value1;
		KeyValue value2;
		if(player2()) {
			value1 = new KeyValue(image1.fitHeightProperty(), 20);
			value2 = new KeyValue(image2.fitHeightProperty(), 40);
		}else{
			value1 = new KeyValue(image2.fitHeightProperty(), 20);
			value2 = new KeyValue(image1.fitHeightProperty(), 40);
		}
		KeyFrame frame = new KeyFrame(Duration.millis(500), value1, value2);
		timeline.getKeyFrames().add(0,frame);
		timeline.play();
	}

	@FXML
	public void swap(){
		swapPlayer();
	}
}
