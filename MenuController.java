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


public class MenuController{
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ImageView menuWindow;

    @FXML
    private ImageView playWindow;

    @FXML
    private Pane playPane;


    public void playGame(MouseEvent mouseEvent) throws IOException{

        //Window switching
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        root = loader.load();
        stage = (Stage)((Node) mouseEvent.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
