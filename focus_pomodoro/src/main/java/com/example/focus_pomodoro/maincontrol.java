package com.example.focus_pomodoro;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class maincontrol extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(maincontrol.class.getResource("pomodoro.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Image icon = new Image(getClass().getResource("/timer.jpg").toExternalForm());

 
        stage.getIcons().add(icon);
        stage.setTitle("FOCUS~POMODORO");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}