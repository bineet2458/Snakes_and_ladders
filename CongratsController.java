package com.example.snakeandladders;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CongratsController {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView congratsWindow;

    @FXML
    private Pane menuPane;

    @FXML
    private Pane replayPane;

    public void goToMenu(MouseEvent mouseEvent) throws IOException {

        System.out.println("Menu button clicked");

        //Window switching
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        root = loader.load();
        stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void playAgain(MouseEvent mouseEvent) throws IOException {

        System.out.println("Play Again button clicked");

        //Window switching
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
