package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

/**
 * Created by ahmed on 2/4/2017.
 */
public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    private Move(final Board board, final Piece piece, final int destinationCoordinate){
        this.board = board;
        this.movedPiece = piece;
        this.destinationCoordinate = destinationCoordinate;
    }

    public int getDestinationCoordinate(){
        return this.destinationCoordinate;
    }

    public static final class MajorMove extends Move{

        public MajorMove(final Board board, final Piece piece, final int destinationCoordinate) {

            super(board, piece, destinationCoordinate);
        }
    }

    public static final class AttackMove extends Move{
        final Piece attackedPiece;
        public AttackMove(final Board board, final Piece piece, final int destinationCoordinate, final Piece attackedPieces) {
            super(board, piece, destinationCoordinate);
            this.attackedPiece = attackedPieces;
        }
    }
}
