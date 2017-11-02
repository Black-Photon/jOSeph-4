package jOSeph_4.games.menu;

import jOSeph_4.core.CorePane;
import jOSeph_4.games.main.NoughtsAndCrosses;
import jOSeph_4.games.main.Chess;
import jOSeph_4.messageBoxes.sourceFiles.Error;
import jOSeph_4.resources.controllers.core.Core_Controller;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Game_Menu_Controller implements Initializable {
	@FXML
	private ImageView image;
	@FXML
	private BorderPane background;

	private GameMenu gameMenu;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		gameMenu = (GameMenu) resources.getObject(resources.getKeys().nextElement());
		Image thisImage = gameMenu.getThisImage();
		image.setImage(thisImage);
		image.fitHeightProperty().bind(background.heightProperty());
	}

	@FXML
	public void onStartPressed(){
		CorePane game = null;
		switch(gameMenu.getGameType()){
			case NOUGHTSANDCROSSES:
				game = new NoughtsAndCrosses();
				break;
			case CHESS:
				game = new Chess();
				break;
			default:
				new Error("No such game found", 600).showModalWindow();
				break;
		}
		Core_Controller.getThisObject().setMainPane(game);

	}
}
