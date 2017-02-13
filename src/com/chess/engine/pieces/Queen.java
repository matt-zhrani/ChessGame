package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtils;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by ahmed on 2/10/2017.
 */
public class Queen extends Piece {

    private final static int [] CANDIDATE_MOVE_VECTOR_COORDINATES = {-9, -8, -7, -1, 1, 7, 8, 9};

    Queen(final int position, final Alliance alliance) {
        super(position, alliance);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        List<Move> legalMoves = new ArrayList<>();

        for(int currentCandidateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES){
            int candidateDestinationCoordinate = this.piecePosition;
            while(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                if(isFirstColumnExclusion(this.piecePosition, currentCandidateOffset) ||
                        isEighthColumnExclusion(this.piecePosition, currentCandidateOffset)){
                    break;
                }
                candidateDestinationCoordinate += currentCandidateOffset;
                if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                    if(!candidateDestinationTile.isTileOccupied()){
                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));
                    }else{
                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                        if(this.getPieceAlliance() != pieceAlliance){
                            legalMoves.add(new Move.AttackMove(board,this,candidateDestinationCoordinate, pieceAtDestination));
                        }
                    }

                }

            }

        }
        return ImmutableList.copyOf(legalMoves);
    }

    private boolean isFirstColumnExclusion(int piecePosition, int candidateCoordinateOffset) {
        return BoardUtils.EIGHTH_COLUMN[piecePosition] && (candidateCoordinateOffset == -1 || candidateCoordinateOffset == -9 || candidateCoordinateOffset == 7);
    }

    private boolean isEighthColumnExclusion(int piecePosition, int candidateCoordinateOffset) {
        return BoardUtils.EIGHTH_COLUMN[piecePosition] && (candidateCoordinateOffset == -7 || candidateCoordinateOffset == 1 || candidateCoordinateOffset == 9);
    }
}
