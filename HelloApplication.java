package com.example.snakeandladders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),408, 400);
        stage.setResizable(false);
        stage.setTitle("Snake and ladder");
        stage.setScene(scene);
        stage.show();

    }


    public static void main(String[] args) {
        launch();
    }


}