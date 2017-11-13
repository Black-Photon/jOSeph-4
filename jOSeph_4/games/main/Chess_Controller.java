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

						//Check for check (pun intended)
						Piece king = null;
						int kingRow = -1;
						int kingColumn = -1;
						if(testCheck(king, kingRow, kingColumn))
							if(testCheckmate(king, kingRow, kingColumn)){
								if(controller.player1()) controller.setTitle("Black checkmated");
								if(controller.player2()) controller.setTitle("White checkmated");
								canClick=false;
							}


						list.set(selected, row, column);
						list.set(Piece.EMPTY_PIECE, selectedRow, selectedColumn);
						selected.nextTurn();
						if(selected.getType()==KING || selected.getType()==ROOK) selected.setCanCastle(false);
						if(selected.getType()==PAWN && modulus(row-selectedRow)==2) selected.setDoubleMove(true);

						if(selected.getType()==PAWN && (row==7 || row==0)) list.set(new Piece(QUEEN, controller.getPlayer()), row, column);


						selectedRow = -1;
						selectedColumn = -1;
						selected = null;
						controller.swap();
						break;
					}
				}
			}
		}
		refresh();
	}

	private boolean testCheck(Piece king, int kingRow, int kingColumn){
		for(int j = 0; j<8; j++) {
			for (int k = 0; k < 8; k++) {
				if(list.get(j,k).getType()==KING && list.get(j,k).getPlayer()!=controller.getPlayer())
					king = list.get(j, k);
				kingRow = j;
				kingColumn = k;
			}
		}
		for(int j = 0; j<8; j++) {
			for (int k = 0; k<8; k++) {
				Piece piece = list.get(j,k);
				if(piece.getPlayer()!=king.getPlayer()){
					//To prevent a loop
					if(piece.getType()==Piece_Type.KING)
						piece.projectKingWithoutCheckConcern(j, k, list);
						//To ensure pawn diagonals are not stepped onto (and forwards can be)
					else if(piece.getType()==Piece_Type.PAWN)
						piece.projectPawnDiagonals(j, k);
					else piece.projectCourse(j, k, list);

					for(Integer[] integers: piece.getCourses()){
						//If in check
						if(integers[0]==kingRow && integers[1]==kingColumn){
							if(controller.player1()) controller.setTitle("Black checked");
							if(controller.player2()) controller.setTitle("White checked");
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Checks for checkmate by mapping every move and seeing if it's still in check
	 * @param king
	 * @param kingRow
	 * @param kingColumn
	 */
	private boolean testCheckmate(Piece king, int kingRow, int kingColumn){
		for(int j = 0; j<8; j++) {
			for (int k = 0; k<8; k++) {
				Piece piece = list.get(j,k);
				if(piece.getPlayer()==king.getPlayer()){
					//No chance of loop with king, so can remove

					//Pawn check is also not necessary as it's the pawn moving
					piece.projectCourse(j, k, list);

					for(Integer[] integers: piece.getCourses()){
						DualList<Piece> dupeList = list;
						//Act's as if the move was made to test for check

						//For en-passe
						if(selected.getType()==PAWN && piece==Piece.EMPTY_PIECE && modulus(j-selectedRow)==1 && modulus(k-selectedColumn)==1) dupeList.set(Piece.EMPTY_PIECE, selectedRow, k);
						//For castling
						if(selected.getType()==KING && piece==Piece.EMPTY_PIECE && modulus(k-selectedColumn)==2){
							Piece castle = dupeList.get(j, k-2);
							//If the 'rook' is not actually a rook, it's the wrong side, so swaps to the other rook
							if(castle.getType()==KING){
								castle = dupeList.get(j, k+1);
								dupeList.set(castle, j, k-1);
								dupeList.set(Piece.EMPTY_PIECE, j, k+1);
							}else{
								castle = dupeList.get(j, k-2);
								dupeList.set(castle, j, k+1);
								dupeList.set(Piece.EMPTY_PIECE, j, k-1);
							}
						}


						dupeList.set(selected, j, k);
						dupeList.set(Piece.EMPTY_PIECE, selectedRow, selectedColumn);
						selected.nextTurn();
						if(selected.getType()==PAWN && (j==7 || j==0)) dupeList.set(new Piece(QUEEN, controller.getPlayer()), j, k);

						Piece king1 = null;
						int kingRow1 = -1;
						int kingColumn1 = -1;
						if(!testCheck(king1, kingRow1, kingColumn1)) return false;
					}
				}
			}
		}
		return true;
	}

	@FXML
	void onResetPressed() {
		setDefaultPlaces();
		selectedRow = -1;
		selectedColumn = -1;
		selected = null;
		if(controller.player2()) controller.swap();
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