package com.geekbrains.chat.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Chat v.1.0");
        primaryStage.setScene(new Scene(root, 400, 450));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
