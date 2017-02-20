package com.chess.engine.player;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.pieces.King;
import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ahmed on 2/17/2017.
 */
public abstract class Player {
    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;
    private boolean isInCheck;

    Player(final Board board, final Collection<Move> legalMoves, final Collection<Move> opponentMoves){

        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = legalMoves;
        this.isInCheck = !Player.calculateAttackOnPlayer(this.playerKing.getPiecePosition(), opponentMoves).isEmpty();

    }

    private static Collection<Move> calculateAttackOnPlayer(final int piecePosition, Collection<Move> moves) {

        final List<Move> attackMoves = new ArrayList<>();

        for(final Move move : moves){
            if(piecePosition == move.getDestinationCoordinate()){
                attackMoves.add(move);
            }
        }
        return ImmutableList.copyOf(attackMoves);
    }

    private King establishKing() {
        for(final Piece piece : getActivePieces()){
            if(piece.getPieceType().isKing()){
                return (King) piece;
            }

        }
        throw new RuntimeException("should not reach here! not a valid board!!");
    }

    public boolean isMoveLegal(final Move move){
        return this.legalMoves.contains(move);
    }

    public boolean isInCheck(){
        return this.isInCheck;
    }

    public boolean isInCheckMate(){
        return this.isInCheck && !hasEscapeMoves();
    }

    protected boolean hasEscapeMoves() {
        for(final Move move: this.legalMoves){
            final MoveTransition transition = makeMove(move);
            if(transition.getMoveStatus().isDone()){
                return true;
            }
        }
        return false;
    }

    public boolean isInStaleMate(){

        return !this.isInCheck && !hasEscapeMoves();
    }

    //TODO more work here!!
    public boolean isCastled(){
        return false;
    }

    public MoveTransition makeMove(final Move move){
        return null;
    }

    protected abstract Collection<Piece> getActivePieces();
    public abstract Alliance getAlliance();
    public abstract Player getOpponent();
}
