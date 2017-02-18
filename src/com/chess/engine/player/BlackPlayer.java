package com.chess.engine.player;

import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.pieces.Piece;

import java.util.Collection;

/**
 * Created by ahmed on 2/17/2017.
 */
public class BlackPlayer extends Player {
    public BlackPlayer(Board board, Collection<Move> whiteStandardLegalMove, Collection<Move> blackStandardLegalMove) {

        super(board, blackStandardLegalMove, whiteStandardLegalMove);
    }

    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getBlackPieces();
    }
}
