package jOSeph_4.games.main;

import jOSeph_4.DualList;
import jOSeph_4.games.Player;
import jOSeph_4.messageBoxes.sourceFiles.Error;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class Piece {
	//Image Name parts
	private static final String IMAGE_PATH = "jOSeph_4/resources/images/game/chess_pieces/";
	private static final String QUEEN = "queen";
	private static final String KING = "king";
	private static final String PAWN = "pawn";
	private static final String BISHOP = "bishop";
	private static final String ROOK = "rook";
	private static final String KNIGHT = "knight";
	private static final String BLACK = "_b.png";
	private static final String WHITE = "_w.png";
	/**
	 * A piece with no info
	 */
	public static final Piece EMPTY_PIECE = new Piece();

	private String imagePath;
	private Player player;
	private Piece_Type type;
	private Image image;
	/**
	 * Arraylist of places the piece can go to
	 */
	private ArrayList<Integer[]> courses;
	/**
	 * Whether this piece moved 2 spaces last turn
	 */
	private boolean doubleMove = false;
	/**
	 * Whether a piece can castle
	 */
	private boolean canCastle = false;

	/**
	 * Only for pawns. True if moves up, false for down
	 */
	private boolean moveUp;

	private Piece(){
		player = Player.NONE;
		type = Piece_Type.NONE;
		imagePath = null;
		image = null;
	}

	public Piece(Piece_Type type, Player player){
		if(player==Player.PLAYER1) moveUp = true;
		else moveUp = false;

		if(type==Piece_Type.ROOK || type == Piece_Type.KING) canCastle = true;

		this.type = type;
		this.player = player;

		//Add's the image path, piece name and final part to get a full path
		imagePath = IMAGE_PATH + pieceToString(type) +
				/* If player1, make white image, if player2, make black ->*/
				((this.player==Player.PLAYER1) ? WHITE : (this.player==Player.PLAYER2) ? BLACK : null);

		image = new Image(imagePath);
	}

	private String pieceToString(Piece_Type type){
		switch(type){
			case KING:
				return KING;
			case PAWN:
				return PAWN;
			case ROOK:
				return ROOK;
			case QUEEN:
				return QUEEN;
			case BISHOP:
				return BISHOP;
			case KNIGHT:
				return KNIGHT;
			default:
				new Error("No such piece").showModalWindow();
		}
		return null;
	}

	/**
	 * Set's all possible places to move to in an arraylist
	 * @param row Current row
	 * @param column Current column
	 * @param list List of positions
	 */
	public void projectCourse(int row, int column, DualList<Piece> list){
		courses = new ArrayList<>();
		switch (type){
			case PAWN:
				projectPawn(row, column, list);
				break;
			case ROOK:
				projectRook(row, column, list);
				break;
			case KNIGHT:
				projectKnight(row, column, list);
				break;
			case BISHOP:
				projectBishop(row, column, list);
				break;
			case QUEEN:
				projectQueen(row, column, list);
				break;
			case KING:
				projectKing(row, column, list);
				break;
		}
	}

	/**
	 * Using on a pawn counts as a new turn, removing the double-move effect
	 */
	public void nextTurn(){
		doubleMove = false;
	}

	//Projections
	private void projectPawn(int row, int column, DualList<Piece> list){
		if(doubleMove){
			doubleMove = false;
		}

		if(moveUp){
			//Double move
			if(row==6){
				if(list.get(row-2, column)==Piece.EMPTY_PIECE && list.get(row-1, column)==Piece.EMPTY_PIECE){
					Integer[] coordinates = {row-2, column};
					courses.add(coordinates);
					doubleMove = true;
				}
			}
			//Move once
			if(list.get(row-1, column)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row-1, column};
				courses.add(coordinates);
			}

			//Move Diagonally
			if(column!=0)
			if(list.get(row-1, column-1)!=Piece.EMPTY_PIECE && list.get(row-1, column-1).player!=player){
				Integer[] coordinates = {row-1, column-1};
				courses.add(coordinates);
			}
			if(column!=7)
			if(list.get(row-1, column+1)!=Piece.EMPTY_PIECE && list.get(row-1, column+1).player!=player){
				Integer[] coordinates = {row-1, column+1};
				courses.add(coordinates);
			}

			//If the piece in front is a pawn which just double-moved, move diagonally
			if(list.get(row-1, column).type==Piece_Type.PAWN && list.get(row-1, column).doubleMove){
				if(column!=0)
					if(list.get(row-1, column-1)==Piece.EMPTY_PIECE && list.get(row-1, column-1).player!=player){
						Integer[] coordinates = {row-1, column-1};
						courses.add(coordinates);
					}
				if(column!=7)
					if(list.get(row-1, column+1)==Piece.EMPTY_PIECE && list.get(row-1, column+1).player!=player){
						Integer[] coordinates = {row-1, column+1};
						courses.add(coordinates);
					}
			}

		}else{
			//Double move
			if(row==6){
				if(list.get(row+2, column)==Piece.EMPTY_PIECE && list.get(row+1, column)==Piece.EMPTY_PIECE){
					Integer[] coordinates = {row+2, column};
					courses.add(coordinates);
					doubleMove = true;
				}
			}
			//Move once
			if(list.get(row+1, column)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row+1, column};
				courses.add(coordinates);
			}

			//Move Diagonally
			if(column!=0)
				if(list.get(row+1, column-1)!=Piece.EMPTY_PIECE && list.get(row+1, column-1).player!=player){
					Integer[] coordinates = {row+1, column-1};
					courses.add(coordinates);
				}
			if(column!=7)
				if(list.get(row+1, column+1)!=Piece.EMPTY_PIECE && list.get(row+1, column+1).player!=player){
					Integer[] coordinates = {row+1, column+1};
					courses.add(coordinates);
				}

			//If the piece in front is a pawn which just double-moved, move diagonally
			if(list.get(row+1, column).type==Piece_Type.PAWN && list.get(row+1, column).doubleMove){
				if(column!=0)
					if(list.get(row+1, column-1)==Piece.EMPTY_PIECE && list.get(row+1, column-1).player!=player){
						Integer[] coordinates = {row+1, column-1};
						courses.add(coordinates);
					}
				if(column!=7)
					if(list.get(row+1, column+1)==Piece.EMPTY_PIECE && list.get(row+1, column+1).player!=player){
						Integer[] coordinates = {row+1, column+1};
						courses.add(coordinates);
					}
			}
		}
	}
	private void projectRook(int row, int column, DualList<Piece> list){
		for(int i = row+1; i<8; i++){
			if(list.get(i, column)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {i, column};
				courses.add(coordinates);
			}else if(list.get(i, column).player!=player){
				Integer[] coordinates = {i, column};
				courses.add(coordinates);
				break;
			}else break;
		}
		for(int i = row-1; i>=0; i--){
			if(list.get(i, column)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {i, column};
				courses.add(coordinates);
			}else if(list.get(i, column).player!=player){
				Integer[] coordinates = {i, column};
				courses.add(coordinates);
				break;
			}else break;
		}
		for(int i = column+1; i<8; i++){
			if(list.get(row, i)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row, i};
				courses.add(coordinates);
			}else if(list.get(row, i).player!=player){
				Integer[] coordinates = {row, i};
				courses.add(coordinates);
				break;
			}else break;
		}
		for(int i = column-1; i>=0; i--){
			if(list.get(row, i)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row, i};
				courses.add(coordinates);
			}else if(list.get(row, i).player!=player){
				Integer[] coordinates = {row, i};
				courses.add(coordinates);
				break;
			}else break;
		}
	}
	private void projectKnight(int row, int column, DualList<Piece> list){
		for(int i = -2; i<3; i++){
			for(int j = -2; j<3; j++){
				//Ensures it's not out of bounds
				if(row+i<8 && row+i>=0 && column+j<8 && column+j>=0){
					if(list.get(row+i, column+j).player!=player || list.get(row+i, column+j)==Piece.EMPTY_PIECE)
					if(modulus(i)+modulus(j)==3){
						Integer[] coordinates = {row+i, column+j};
						courses.add(coordinates);
					}
				}
			}
		}
	}
	private void projectBishop(int row, int column, DualList<Piece> list){
		for(int i = 1; row+i<8 && column+i<8; i++){
			if(list.get(row+i, column+i)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row+i, column+i};
				courses.add(coordinates);
			}else if(list.get(row+i, column+i).player!=player){
				Integer[] coordinates = {row+i, column+i};
				courses.add(coordinates);
				break;
			}else break;
		}
		for(int i = 1; row-i>=0 && column+i<8; i++){
			if(list.get(row-i, column+i)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row-i, column+i};
				courses.add(coordinates);
			}else if(list.get(row-i, column+i).player!=player){
				Integer[] coordinates = {row-i, column+i};
				courses.add(coordinates);
				break;
			}else break;
		}
		for(int i = 1; row+i<8 && column+i>=0; i++){
			if(list.get(row+i, column-i)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row+i, column-i};
				courses.add(coordinates);
			}else if(list.get(row+i, column-i).player!=player){
				Integer[] coordinates = {row+i, column-i};
				courses.add(coordinates);
				break;
			}else break;
		}
		for(int i = 1; row+i>=0 && column+i>=0; i++){
			if(list.get(row-i, column-i)==Piece.EMPTY_PIECE){
				Integer[] coordinates = {row-i, column-i};
				courses.add(coordinates);
			}else if(list.get(row-i, column-i).player!=player){
				Integer[] coordinates = {row-i, column-i};
				courses.add(coordinates);
				break;
			}else break;
		}
	}
	private void projectQueen(int row, int column, DualList<Piece> list){
		projectRook(row, column, list);
		projectBishop(row, column, list);
	}
	private void projectKing(int row, int column, DualList<Piece> list){
		for(int i = -1; i<2; i++){
			for(int j = -1; j<2; j++){
				if(i!=0 && j!=0 && !(row+i<8 && row+i>=0) && !(column+j<8 && column+j>=0)) {
					if (list.get(row + i, column + j).player != player && list.get(row + i, column + j).player != player){
						Integer[] coordinates = {row + i, column + j};
						courses.add(coordinates);
					}
				}
			}
		}

		//Ensure you can't move to check
		for(int i = 0; i<8; i++) {
			for (int j = 0; j<8; j++) {
				Piece piece = list.get(i,j);
				if(piece.player!=player){
					piece.projectCourse(i, j, list);
					for(Integer[] integers: piece.courses){
						for(Integer[] integers1: courses){
							if(integers == integers1){
								courses.remove(integers);
							}
						}
					}
				}
			}
		}
	}

	private int modulus(int i){
		if(i<0) return -i;
		return i;
	}


	public String getImagePath() {
		return imagePath;
	}

	public Player getPlayer() {
		return player;
	}

	public Piece_Type getType() {
		return type;
	}

	public Image getImage() {
		return image;
	}

	public boolean isMoveUp() {
		return moveUp;
	}

	public void setMoveUp(boolean moveUp) {
		this.moveUp = moveUp;
	}

	public boolean isDoubleMove() {
		return doubleMove;
	}
}
