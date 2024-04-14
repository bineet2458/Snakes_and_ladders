package com.example.snakeandladders;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class HelloController {

    private static final int BOARDCELL_WIDTH = 40;
    private static final int BOARDCELL_HEIGHT = 50;
    private static boolean gameFinished = false;

    private Player player1;
    private Player player2;


    private static ArrayList<BoardCell> boardCellList = new ArrayList<>();


    @FXML
    private Pane layout;

    @FXML
    private ImageView boardImage;

    @FXML
    private ImageView playerBlue;

    @FXML
    private ImageView playerGreen;

    @FXML
    private ImageView diceImage;

    @FXML
    private ImageView greenTokenImage;

    @FXML
    private ImageView blueTokenImage;

    @FXML
    private ImageView yellowArrow;


    public void rollDice() {

        int diceValue = new Random().nextInt(6) + 1;

        Image img;

        switch (diceValue) {
            case 1: img = new Image(getClass().getResourceAsStream("Dice_1.jpg"));
                    break;
            case 2: img = new Image(getClass().getResourceAsStream("Dice_2.jpg"));
                break;
            case 3: img = new Image(getClass().getResourceAsStream("Dice_3.jpg"));
                break;
            case 4: img = new Image(getClass().getResourceAsStream("Dice_4.jpg"));
                break;
            case 5: img = new Image(getClass().getResourceAsStream("Dice_5.jpg"));
                break;
            case 6:img = new Image(getClass().getResourceAsStream("Dice_6.jpg"));
                break;
            default: img = new Image(getClass().getResourceAsStream("Dice_2.jpg"));
        }

        diceImage.setImage(img);

        if (gameFinished == false) {
            if (player1.isTurn() == true) {


                if (player1.isStarted() == false)
                    startGame(diceValue, player1);
                else
                    moveTo(diceValue, player1);
            } else if (player2.isTurn() == true) {


                if (player2.isStarted() == false)
                    startGame(diceValue, player2);
                else
                    moveTo(diceValue, player2);
            }


            if (player1.isTurn() == true) {
                player1.setTurn(false);
                player2.setTurn(true);
                blueTokenImage.setOpacity(0.4);
                greenTokenImage.setOpacity(1);
            } else {
                player1.setTurn(true);
                player2.setTurn(false);
                blueTokenImage.setOpacity(1);
                greenTokenImage.setOpacity(0.4);
            }
        }
    }

    public void initialize() {
        player1 = new Player(playerBlue);
        player2 = new Player(playerGreen);
        player1.setTurn(true);
        translateArrow();
        initialiseBoardCells();
        
    }

    public void initialiseBoardCells() {
        // 1st Cell Initialised
        boardCellList.add(new BoardCell(1, 135, 581));

        for (int i = 2; i <= 10; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() + BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        // 11th Cell Initialised
        boardCellList.add(new BoardCell(11, boardCellList.get(9).getxVal(),
                boardCellList.get(9).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 12; i <= 20; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() - BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //21st cell initialised
        boardCellList.add(new BoardCell(21, boardCellList.get(19).getxVal(),
                boardCellList.get(19).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 22; i <= 30; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() + BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //31st cell initialised
        boardCellList.add(new BoardCell(31, boardCellList.get(29).getxVal(),
                boardCellList.get(29).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 32; i <= 40; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() - BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //41st cell initialised
        boardCellList.add(new BoardCell(41, boardCellList.get(39).getxVal(),
                boardCellList.get(39).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 42; i <= 50; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() + BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //51st cell initialised
        boardCellList.add(new BoardCell(51, boardCellList.get(49).getxVal(),
                boardCellList.get(49).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 52; i <= 60; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() - BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //61st cell initialised
        boardCellList.add(new BoardCell(61, boardCellList.get(59).getxVal(),
                boardCellList.get(59).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 62; i <= 70; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() + BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //71st cell initialised
        boardCellList.add(new BoardCell(71, boardCellList.get(69).getxVal(),
                boardCellList.get(69).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 72; i <= 80; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() - BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //81st cell initialised
        boardCellList.add(new BoardCell(81, boardCellList.get(79).getxVal(),
                boardCellList.get(79).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 82; i <= 90; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() + BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //91st cell initialised
        boardCellList.add(new BoardCell(91, boardCellList.get(89).getxVal(),
                boardCellList.get(89).getyVal() - BOARDCELL_HEIGHT));

        for (int i = 92; i <= 100; i++) {
            boardCellList.add(new BoardCell(i, boardCellList.get(i - 2).getxVal() - BOARDCELL_WIDTH,
                    boardCellList.get(i - 2).getyVal()));
        }

        //LADDER values

        //1's row
        boardCellList.get(4).setLadderVal(17);
        boardCellList.get(6).setLadderVal(15);
        boardCellList.get(8).setLadderVal(13);

        //30's row
        boardCellList.get(32).setLadderVal(47);
        boardCellList.get(34).setLadderVal(45);
        boardCellList.get(36).setLadderVal(43);

        //60's row
        boardCellList.get(63).setLadderVal(83);
        boardCellList.get(65).setLadderVal(85);
        boardCellList.get(67).setLadderVal(87);

        //Longest ladder
        boardCellList.get(39).setLadderVal(81);

        //SNAKE values

        //20's row
        boardCellList.get(23).setSnakeVal(18);
        boardCellList.get(25).setSnakeVal(16);
        boardCellList.get(27).setSnakeVal(14);

        //50's row
        boardCellList.get(54).setSnakeVal(34);
        boardCellList.get(56).setSnakeVal(36);
        boardCellList.get(58).setSnakeVal(38);

        //90's row
        boardCellList.get(94).setSnakeVal(74);
        boardCellList.get(96).setSnakeVal(76);
        boardCellList.get(98).setSnakeVal(78);

        //Long snake
        boardCellList.get(90).setSnakeVal(50);
    }


    public void moveTo(int diceValue, Player playerName) {
        int finalBoardCellId = playerName.getCurrentBoardCellId() + diceValue;

        if (finalBoardCellId > 100)
            return;

        if (finalBoardCellId == 100) {
            gameFinished = true;

        }

        if (boardCellList.get(finalBoardCellId - 1).getSnakeVal() != -1) {
            finalBoardCellId = boardCellList.get(finalBoardCellId - 1).getSnakeVal();
        } else if (boardCellList.get(finalBoardCellId - 1).getLadderVal() != -1) {
            finalBoardCellId = boardCellList.get(finalBoardCellId - 1).getLadderVal();
        }

        double currX, currY;

        if (playerName.getCurrentBoardCellId() == 0) {
            currX = playerName.getToken().getLayoutX();
            currY = playerName.getToken().getLayoutY();
        } else {
            currX = boardCellList.get(playerName.getCurrentBoardCellId() - 1).getxVal();
            currY = boardCellList.get(playerName.getCurrentBoardCellId() - 1).getyVal();
        }


        playerName.setCurrentBoardCellId(finalBoardCellId);
        double finalX = boardCellList.get(finalBoardCellId - 1).getxVal();
        double finalY = boardCellList.get(finalBoardCellId - 1).getyVal();



        TranslateTransition moveToken = new TranslateTransition();
        moveToken.setNode(playerName.getToken());
        moveToken.setDuration(Duration.millis(200));
        moveToken.setByX(finalX - currX);
        moveToken.setByY(finalY - currY);
        moveToken.play();


    }

    public void startGame(int diceValue, Player player) {
        if (diceValue == 1) {
            player.setStarted(true);
            moveTo(diceValue, player);
            player.setCurrentBoardCellId(1);
        }
    }


    public void translateArrow() {
        TranslateTransition moveArrow = new TranslateTransition();
        moveArrow.setNode(yellowArrow);
        moveArrow.setDuration(Duration.millis(500));
        moveArrow.setCycleCount(TranslateTransition.INDEFINITE);
        moveArrow.setByY(20);
        moveArrow.setAutoReverse(true);
        moveArrow.play();
    }



    private Stage stage;
    private Scene scene;
    private Parent root;
    public void congrats(MouseEvent event) throws IOException{

        if (player1.getCurrentBoardCellId() == 100){
            System.out.println("YES1");
            //Window switching
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Congrats1.fxml"));
            root = loader.load();
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            player1.setCurrentBoardCellId(0);
            player2.setCurrentBoardCellId(0);
            gameFinished = false;

        } else if (player2.getCurrentBoardCellId() == 100){
            System.out.println("YES2");
            //Window switching
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Congrats2.fxml"));
            root = loader.load();
            stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            player1.setCurrentBoardCellId(0);
            player2.setCurrentBoardCellId(0);
            gameFinished = false;

        }

    }

}