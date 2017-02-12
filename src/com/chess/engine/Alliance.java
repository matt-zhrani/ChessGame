package com.chess.engine;

/**
 * Created by ahmed on 2/4/2017.
 */
public enum Alliance {
    black {
        @Override
        public int getDirection() {
            return 1;
        }
    },
    white {
        @Override
        public int getDirection() {
            return -1;
        }
    };

    public abstract int getDirection();
}
