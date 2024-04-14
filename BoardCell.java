package com.example.snakeandladders;

public class BoardCell {
    private int id;
    private int xVal;
    private int yVal;

    //snakeVal tells us to which id we have to go in case snake is present at current Boardcell.
    // if no snake is present, snakeVal = -1
    private int snakeVal;
    private int ladderVal;

    BoardCell(int _id, int _xVal, int _yVal){
        this.id = _id;
        this.xVal = _xVal;
        this.yVal = _yVal;
        this.snakeVal = -1;
        this.ladderVal = -1;
    }

    public int getxVal() {
        return xVal;
    }

    public int getyVal() {
        return yVal;
    }

    public int getSnakeVal() {
        return snakeVal;
    }

    public int getLadderVal() {
        return ladderVal;
    }

    public void setSnakeVal(int snakeVal) {
        this.snakeVal = snakeVal;
    }

    public void setLadderVal(int ladderVal) {
        this.ladderVal = ladderVal;
    }
}
