package jOSeph_4.games.main;

import jOSeph_4.DualList;
import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.games.Player;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Stack;

import static jOSeph_4.games.Player.*;
import static jOSeph_4.games.Player.NONE;
import static jOSeph_4.games.main.Piece_Type.*;

public class Chess_Controller implements Initializable{

	@FXML
	private GridPane grid;

	private Game_Controller controller;

	/**
	 * Whether the player is allowed to activate the click event
	 */
	private boolean canClick = true;


	private final int ROWS = 8;
	private final int COLUMNS = 8;

	private DualList<Piece> list = new DualList<>(ROWS, COLUMNS);

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		grid.getStylesheets().add("jOSeph_4/resources/css/core/game.css");
		grid.getStyleClass().add("grid");

		//Add's image areas to grid
		for(int i = 0; i<ROWS; i++){
			for(int j = 0; j<COLUMNS; j++){
				ImageView image = new ImageView();
				StackPane stackPane = new StackPane();
				if(i%2==0 && j%2!=0){
					stackPane.getStyleClass().add("black");
				}
				if(i%2!=0 && j%2==0){
					stackPane.getStyleClass().add("black");
				}
				stackPane.getChildren().add(image);
				stackPane.setPrefWidth(30);
				stackPane.setPrefHeight(30);
				GridPane.setConstraints(stackPane, i, j);
				grid.getChildren().add(stackPane);
			}
		}
		if(Variable.getWindow().getHeight()<550)
		Variable.getWindow().setHeight(600);

		setDefaultPlaces();

		Enumeration<String> keys = resources.getKeys();
		Game game = (Game) resources.getObject(keys.nextElement());
		controller = (Game_Controller) resources.getObject(keys.nextElement());
	}

	private void setDefaultPlaces(){
		//Set's empty pieces
		for(int i = 2; i<6; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				list.set(Piece.EMPTY_PIECE, i,j);
			}
		}

		//Set's pawns
		for (int i = 0; i < COLUMNS; i++) {
			list.set(new Piece(PAWN, Player.PLAYER1), 1, i);
		}
		for (int i = 0; i < COLUMNS; i++) {
			list.set(new Piece(PAWN, Player.PLAYER2), 6, i);
		}

		//Set's others
		list.set(new Piece(ROOK, Player.PLAYER1), 0, 0);
		list.set(new Piece(ROOK, Player.PLAYER1), 0, 7);
		list.set(new Piece(KNIGHT, Player.PLAYER1), 0, 1);
		list.set(new Piece(KNIGHT, Player.PLAYER1), 0, 6);
		list.set(new Piece(BISHOP, Player.PLAYER1), 0, 2);
		list.set(new Piece(BISHOP, Player.PLAYER1), 0, 5);
		list.set(new Piece(QUEEN, Player.PLAYER1), 0, 3);
		list.set(new Piece(KING, Player.PLAYER1), 0, 4);

		list.set(new Piece(ROOK, Player.PLAYER2), 7, 0);
		list.set(new Piece(ROOK, Player.PLAYER2), 7, 7);
		list.set(new Piece(KNIGHT, Player.PLAYER2), 7, 1);
		list.set(new Piece(KNIGHT, Player.PLAYER2), 7, 6);
		list.set(new Piece(BISHOP, Player.PLAYER2), 7, 2);
		list.set(new Piece(BISHOP, Player.PLAYER2), 7, 5);
		list.set(new Piece(QUEEN, Player.PLAYER2), 7, 3);
		list.set(new Piece(KING, Player.PLAYER2), 7, 4);

		refresh();
	}

	private void refresh(){
		for(int i = 0; i<ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				ImageView image = (ImageView) ((StackPane) getNodeFromGridPane(grid, j, i)).getChildren().get(0);
				image.setImage(list.get(i,j).getImage());
			}
		}
	}

	@FXML
	void onGridPaneClick(MouseEvent e) {
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

		if(list.get(row, column)== Piece.EMPTY_PIECE) return;


	}

	@FXML
	void onResetPressed() {
		setDefaultPlaces();
	}

	@FXML
	void onRotatePressed() {
		DualList<Piece> old = this.list;
		list = new DualList<>();

		for(int i = 0; i<ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				//Swaps the top to bottom
				list.set(old.get(ROWS-i-1, j), i,j);

				Piece piece = list.get(i,j);
				if(piece.getType()==PAWN) piece.setMoveUp(!piece.isMoveUp());
			}
		}
		refresh();
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