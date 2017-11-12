package jOSeph_4.games.main;

import jOSeph_4.DualList;
import jOSeph_4.games.Player;
import jOSeph_4.messageBoxes.sourceFiles.Error;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.ResourceBundle;

import static jOSeph_4.games.Player.*;


public class NoughtsAndCrosses_Controller implements Initializable{

	@FXML
	private GridPane grid;

	private Game_Controller controller;

	private final Image image1_n = new Image("jOSeph_4/resources/images/game/nought.png");
	private final Image image2_c = new Image("jOSeph_4/resources/images/game/cross.png");

	private Player winner = NONE;

	/**
	 * Whether the player is allowed to activate the click event
	 */
	private boolean canClick = true;

	private DualList<Player> list = new DualList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Enumeration<String> keys = resources.getKeys();
		Game game = (Game) resources.getObject(keys.nextElement());
		controller = (Game_Controller) resources.getObject(keys.nextElement());

		onResetPressed();
	}

	@FXML
	public void onGridPaneClick(MouseEvent e){
		if(!canClick) return;

		int column = -1, row = -1;
		for(Node node: grid.getChildren()) {
			if(node.getBoundsInParent().contains(e.getX(), e.getY())) {
				column = GridPane.getColumnIndex(node);
				row = GridPane.getRowIndex(node);
				break;
			}
		}
		if(column==-1 || row==-1) return;

		if(list.get(row, column)!= NONE) return;

		if(controller.player1()){
			list.set(Player.PLAYER1, row, column);
		}else if(controller.player2()){
			list.set(Player.PLAYER2, row, column);
		}
		refresh();
		if(controller.player1()&&winner==PLAYER2) controller.swap();
		if(controller.player2()&&winner==PLAYER1) controller.swap();
		if(winner==DRAW) controller.neutralImage();
		if(winner==NONE) controller.swap();
	}

	/**
	 * Reset's the board to NONE
	 */
	@FXML
	public void onResetPressed(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				list.set(NONE, i, j);
			}
		}
		refresh();

		canClick = true;
		if(winner==DRAW){
			controller.setPlayer(PLAYER2);
			controller.swap();
		}

		winner=NONE;

		if(controller.player2()) controller.swap();
	}

	/**
	 * Refresh's the board, and checks for end
	 */
	private void refresh(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				ImageView imageView = (ImageView) getNodeFromGridPane(grid, j, i);

				switch(list.get(i, j)) {
					case NONE:
						imageView.setImage(null);
						break;
					case PLAYER1:
						imageView.setImage(image1_n);
						break;
					case PLAYER2:
						imageView.setImage(image2_c);
						break;
					default:
						new Error("Error in NoughtsAndCrosses_Controller.java: No such Player found", 800).showModalWindow();
				}
			}
		}
		if(checkForWin(PLAYER1)) return;
		if(checkForWin(PLAYER2)) return;

		if(isFull()){
			onDraw();
		}

	}

	/**
	 * @return true if the board is filled with anything but NONE
	 */
	private boolean isFull(){
		for(ArrayList<Player> row: list.getListOfRows()) {
			for (Player node : row) {
				if(node==NONE) return false;
			}
		}
		return true;
	}

	/**
	 * @param player Player to test for a win
	 * @return true if the player won
	 */
	private boolean checkForWin(Player player){
		boolean win = false;
		for(ArrayList<Player> row: list.getListOfRows()){
			for(Player node: row){
				if(node!=player){
					win = false;
					break;
				}else{
					win = true;
				}
			}
			if(win){
				onWin(player);
				return true;
			}
		}
		for(ArrayList<Player> column: list.getListOfColumns()){
			for(Player node: column){
				if(node!=player){
					win = false;
					break;
				}else{
					win = true;
				}
			}
			if(win){
				onWin(player);
				return true;
			}
		}
		//Diagonals
		if( (   list.get(0,0)==player &&
				list.get(1,1)==player &&
				list.get(2,2)==player
								)	||  (
				list.get(0,2)==player &&
				list.get(1,1)==player &&
				list.get(2,0)==player) )
		{
			onWin(player);
			return true;
		}

		return false;
	}

	/**
	 * Set's win text
	 * @param player Player to congratulate
	 */
	private void onWin(Player player){
		winner = player;
		if(player==PLAYER1){
			controller.setTitle("Noughts Won!");
		}else if(player==PLAYER2){
			controller.setTitle("Crosses Won!");
		}
		canClick = false;
	}

	/**
	 * Set's draw text
	 */
	private void onDraw(){
		winner = DRAW;

		controller.setTitle("It's a Draw");

		canClick = false;
	}


	/**
	 * Get's a specific gridpane node
	 * @param gridPane To test
	 * @param col Column to get node of
	 * @param row Row to get node of
	 * @return Node of the given coordinates
	 */
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
		for (Node node : gridPane.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}
}
