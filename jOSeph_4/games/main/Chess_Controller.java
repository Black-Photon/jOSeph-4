package jOSeph_4.games.main;

import jOSeph_4.DualList;
import jOSeph_4.Main;
import jOSeph_4.Variable;
import jOSeph_4.games.Player;
import jOSeph_4.messageBoxes.sourceFiles.Error;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.util.Arrays;
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
	private Piece selected = null;
	private int selectedRow = -1;
	private int selectedColumn = -1;
	private String showText = null;


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

		Piece thisPiece = list.get(row, column);

		//If click on blank space
		if(thisPiece == Piece.EMPTY_PIECE && selected==null) return;

		//If click on wrong player
		if(thisPiece.getPlayer()==controller.otherPlayer(controller.getPlayer()) && selected==null) return;

		if(selected==null){
			selected = thisPiece;
			selectedColumn = column;
			selectedRow = row;
		}else{
			if(thisPiece.getPlayer()==controller.getPlayer()){
				selected = thisPiece;
				selectedColumn = column;
				selectedRow = row;
				return;
			}
			if(thisPiece==Piece.EMPTY_PIECE || thisPiece.getPlayer()==controller.otherPlayer(controller.getPlayer())){
				selected.projectCourse(selectedRow, selectedColumn, list);
				for(Integer[] i: selected.getCourses()){
					if(row == i[0] && column == i[1]){
						//WHAT TO DO IF YOU CAN MOVE TO THE PIECE YOU TRY TO:

						//Get's the king piece for the current player
						Integer[] kingCoords = {-1,-1};
						Outside:
						for(int j = 0; j<ROWS; j++){
							for(int k = 0; k<COLUMNS; k++){
								if(selected.getType()==KING) {
									kingCoords[0] = row;
									kingCoords[1] = column;
									break Outside;
								}else if (list.get(j, k).getType()==KING && list.get(j, k).getPlayer()==controller.getPlayer()){
									kingCoords[0] = j;
									kingCoords[1] = k;
									break Outside;
								}
							}
						}

						//Get's the other king piece for the current player
						Integer[] otherKingCoords = {-1,-1};
						Outside:
						for(int j = 0; j<ROWS; j++){
							for(int k = 0; k<COLUMNS; k++){
								if(selected.getType()==KING) {
									kingCoords[0] = row;
									kingCoords[1] = column;
									break Outside;
								}else if (list.get(j, k).getType()==KING && list.get(j, k).getPlayer()==controller.otherPlayer(controller.getPlayer())){
									otherKingCoords[0] = j;
									otherKingCoords[1] = k;
									break Outside;
								}
							}
						}

						DualList<Piece> dupeList = list.duplicate();

						//Makes the move in a dummy environment
						performSpecial(thisPiece, row, column, dupeList);
						dupeList.set(selected, row, column);
						dupeList.set(Piece.EMPTY_PIECE, selectedRow, selectedColumn);
						if(selected.getType()==PAWN && (row==7 || row==0)) dupeList.set(new Piece(QUEEN, controller.getPlayer()), row, column);


						//Check for check (pun intended)
						if(isInCheck(controller.getPlayer(), kingCoords, dupeList)){
							return;
						}else if(isInCheck(controller.otherPlayer(controller.getPlayer()), otherKingCoords, dupeList)){
							if(isInCheckmate(controller.otherPlayer(controller.getPlayer()), otherKingCoords, dupeList)){
								if(controller.player1()) showText = "White's Checkmate";
								if(controller.player2()) showText = "Black's Checkmate";
								canClick = false;
							}else{
								if(controller.player1()) showText = "White's Check";
								if(controller.player2()) showText = "Black's Check";
							}
						}
						//If not check, continue as if it were real
						list = dupeList;
						selected.nextTurn();
						if(selected.getType()==KING || selected.getType()==ROOK) selected.setCanCastle(false);
						if(selected.getType()==PAWN && modulus(row-selectedRow)==2) selected.setDoubleMove(true);

						selectedRow = -1;
						selectedColumn = -1;
						selected = null;
						//Prevent swapping for a checkmate
						if(canClick) controller.swap();
						if(showText!=null) controller.setTitle(showText);
						showText = null;
						break;
					}
				}
			}
		}
		refresh();
	}

	private boolean isInCheck(Player player, Integer[] kingCoords, DualList<Piece> list){
		//For every piece
		for(int i = 0; i<ROWS; i++){
			for(int j = 0; j<COLUMNS; j++){
				Piece piece = list.get(i, j);
				//Ignore if it's the current players piece
				//Or only check if it's an enemy piece
				if(piece.getPlayer()==controller.otherPlayer(player)) {
					piece.projectCourse(i, j, list);
					if(piece.getType()==PAWN) piece.projectPawnDiagonals(i, j);
					//For each possible move
					for (Integer[] course : piece.getCourses()) {
						if (course[0].equals(kingCoords[0]) && course[1].equals(kingCoords[1])) //The king can move to block it's last position
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isInCheckmate(Player player, Integer[] kingCoords, DualList<Piece> list){
		//Duplicates the list to test on
		DualList<Piece> dupeList = list.duplicate();

		Piece tempSelected = selected;
		int tempSelectedRow = selectedRow;
		int tempSelectedColumn = selectedColumn;

		//For every piece
		for(int i = 0; i<ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				Piece piece = list.get(i, j);
				//Only check if it's the players piece (As they're the only one's you can move)
				if(piece.getPlayer()==player) {
					piece.projectCourse(i,j, dupeList);
					//For each possible move
					for (Integer[] course : piece.getCourses()) {
						//Acts out move in dupelist
						dupeList = list.duplicate();
						selected = piece;
						selectedRow = i;
						selectedColumn = j;

						performSpecial(dupeList.get(course[0], course[1]), course[0], course[1], dupeList);
						dupeList.set(selected, course[0], course[1]);
						dupeList.set(Piece.EMPTY_PIECE, selectedRow, selectedColumn);

						if(selected.getType()==PAWN && (course[0]==7 || course[0]==0)) dupeList.set(new Piece(QUEEN, controller.getPlayer()), course[0], course[1]);

						Integer[] newKingCoords = {-1,-1};

						//In case the king moves - So the king can't block itself
						if(piece.getType()==KING){
							newKingCoords[0] = course[0];
							newKingCoords[1] = course[1];
						}

						if(newKingCoords[0]!=-1 && newKingCoords[1]!=-1){
							if(!isInCheck(player, newKingCoords, dupeList)){
								selected = tempSelected;
								selectedRow = tempSelectedRow;
								selectedColumn = tempSelectedColumn;
								return false;
							}
							newKingCoords[0] = -1;
							newKingCoords[1] = -1;
						} else
						if(!isInCheck(player, kingCoords, dupeList)){
							selected = tempSelected;
							selectedRow = tempSelectedRow;
							selectedColumn = tempSelectedColumn;
							return false;
						}
					}
				}
			}
		}
		selected = tempSelected;
		selectedRow = tempSelectedRow;
		selectedColumn = tempSelectedColumn;
		return true;
	}

	/**
	 * Moves pieces from castling ect.
	 * @param thisPiece Current piece clicked by user
	 * @param row Row clicked on
	 * @param column column clicked on
	 */
	private void performSpecial(Piece thisPiece, int row, int column, DualList<Piece> list){
		//For en-passe
		if(selected.getType()==PAWN && thisPiece==Piece.EMPTY_PIECE && modulus(row-selectedRow)==1 && modulus(column-selectedColumn)==1) list.set(Piece.EMPTY_PIECE, selectedRow, column);
		//For castling
		if(selected.getType()==KING && thisPiece==Piece.EMPTY_PIECE && modulus(column-selectedColumn)==2){
			Piece castle = list.get(row, column-2);
			//If the 'rook' is not actually a rook, it's the wrong side, so swaps to the other rook
			if(castle.getType()==KING){
				castle = list.get(row, column+1);
				list.set(castle, row, column-1);
				list.set(Piece.EMPTY_PIECE, row, column+1);
			}else{
				castle = list.get(row, column-2);
				list.set(castle, row, column+1);
				list.set(Piece.EMPTY_PIECE, row, column-2);
			}
		}
	}

	@FXML
	void onResetPressed() {
		setDefaultPlaces();
		selectedRow = -1;
		selectedColumn = -1;
		selected = null;
		if(controller.player2()) controller.swap();
		canClick = true;
		controller.setTitle("White's Turn");
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

	private int modulus(int i){
		if(i<0) return -i;
		return i;
	}


}