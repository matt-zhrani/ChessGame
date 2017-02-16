package com.chess.engine;

import com.chess.engine.board.Board;

/**
 * Created by ahmed on 2/16/2017.
 */
public class JChess {

    public static void main(String []args){
        Board board = Board.createStandardBoard();
        System.out.println(board);
    }
}
