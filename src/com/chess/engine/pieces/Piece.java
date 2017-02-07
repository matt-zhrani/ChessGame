/**
 * Created by ahmed on 2/3/2017.
 */
package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;

import java.util.Collection;

public abstract class Piece {

    protected final int piecePosition;
    protected final Alliance pieceAlliance;

    Piece(final int position, final Alliance alliance) {
        this.pieceAlliance = alliance;
        this.piecePosition = position;
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);
}
