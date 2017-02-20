package com.chess.engine.player;

/**
 * Created by ahmed on 2/20/2017.
 */
public enum MoveStatus {
    DONE {
        @Override
        boolean isDone() {
            return true;
        }
    };

    abstract boolean isDone();
}
