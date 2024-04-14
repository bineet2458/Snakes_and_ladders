package com.example.snakeandladders;

import javafx.scene.image.ImageView;

public class Player {
    private int currentBoardCellId;
    private boolean started;
    private boolean turn;
    private ImageView token;

    Player(ImageView _player){
        this.token = _player;
        this.turn = false;
        this.started = false;
        this.currentBoardCellId = 0;
    }

    public int getCurrentBoardCellId() {
        return currentBoardCellId;
    }

    public void setCurrentBoardCellId(int currentBoardCellId) {
        this.currentBoardCellId = currentBoardCellId;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public ImageView getToken() {
        return token;
    }

}
