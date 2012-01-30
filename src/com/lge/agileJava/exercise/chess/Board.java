package com.lge.agileJava.exercise.chess;

import java.util.ArrayList;
import com.lge.agileJava.exercise.pieces.Piece;
import com.lge.agileJava.exercise.pieces.Piece.Color;
import com.lge.agileJava.exercise.pieces.Piece.Type;

/**
 * Board class for chess game world.
 * 
 * @author wonyoung.jang
 *
 */
public class Board {
	private ArrayList<Piece> pieces = new ArrayList<Piece>();
	
	Board() { }
	/**
	 * Get a number of pieces pawn
	 * @return number of pieces
	 */
	public int pieceCount() {
		return Piece.getCount();
	}

	/**
	 * Add Pawn object to Board
	 * @param pawn
	 */
	public void add(Piece pawn) {
		pieces.add(pawn);
	}

	/**
	 * Get Pawn object from Board
	 * @param index
	 * @return
	 */
	public Piece get(int index) {
		return pieces.get(index);
	}
	
	public void initialize() {
		Piece.resetCount();
		add(Piece.createWhiteRook());
		add(Piece.createWhiteKnight());
		add(Piece.createWhiteBishop());
		add(Piece.createWhiteQueen());
		add(Piece.createWhiteKing());
		add(Piece.createWhiteBishop());
		add(Piece.createWhiteKnight());
		add(Piece.createWhiteRook());
		for (int i=0; i<8;i++) {
			add(Piece.createWhitePawn());
		}
		for (int i=0; i<8*4;i++) {
			add(Piece.noPiece());
		}
		for (int i=0; i<8;i++) {
			add(Piece.createBlackPawn());
		}
		add(Piece.createBlackRook());
		add(Piece.createBlackKnight());
		add(Piece.createBlackBishop());
		add(Piece.createBlackQueen());
		add(Piece.createBlackKing());
		add(Piece.createBlackBishop());
		add(Piece.createBlackKnight());
		add(Piece.createBlackRook());
	}
	public String getRank(int rank) {
		StringBuilder string = new StringBuilder();
		int i = 0;
		for (Piece pawn : pieces) {
			if (i >= rank*8 && i < (rank+1) * 8)
				string.append(pawn.getRepresentation());
			i++;
		}
		
		return string.toString();
	}
	
	public String print() {
		StringBuilder buffer = new StringBuilder();

		for (int i=7;i>=0;i--) {
			buffer.append(StringUtil.appendNewLine(getRank(i)));
		}
		
		return buffer.toString();
	}
	
	public int getNumberofPieces(Color color, Type type) {
		int count = 0;
		for (Piece piece : pieces) {
			if (piece.getColor() == color && piece.getType() == type)
				count++;
		}
		return count;
	}
	public Piece retrievePiece(String location) {
		int index;
		index = location.charAt(0) - 'a';
		index += (location.charAt(1) - '1') * 8;
		return pieces.get(index);
	}
}
