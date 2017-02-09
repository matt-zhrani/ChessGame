package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ahmed on 2/9/2017.
 */
public class Bishop extends Piece {

    private final static int [] CANDIDATE_MOVE_VECTOR_COORDINATES = {-7, -9, 7, 9};
    Bishop(int position, Alliance alliance) {
        super(position, alliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {

        List<Move> legalMoves = new ArrayList<>();

        for(final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES){
            int candidateDestinationCoordinate = this.piecePosition;
            while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){

            }
        }

        return null;
    }
}
