package com.example.focus_pomodoro;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class shortbreak {

    @FXML
    private Label minuteabel;

    @FXML
    private Label secondlabel;

    @FXML
    private Button startbutton;
    @FXML
    private Button pauseButton;

    private Integer timeSeconds = 5 * 60;
    private Timeline countdownTimeline;


    @FXML
    private void initialize() {
        startbutton.setOnAction(event -> startCountdown());
        pauseButton.setOnAction(event -> pauseCountdown());
    }

    @FXML
    private void startCountdown() {
        if (countdownTimeline != null) {
            countdownTimeline.stop();
        }

        countdownTimeline = new Timeline();
        countdownTimeline.setCycleCount(Timeline.INDEFINITE);
        countdownTimeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        event -> {
                            timeSeconds--;
                            minuteabel.setText(String.format("%02d", timeSeconds / 60));
                            secondlabel.setText(String.format("%02d", timeSeconds % 60));
                            if (timeSeconds <= 0) {
                                countdownTimeline.stop();
                                timeSeconds = 5 * 60;
                                minuteabel.setText(String.format("%02d", timeSeconds / 60));
                                secondlabel.setText(String.format("%02d", timeSeconds % 60));
                                pauseCountdown();
                            }
                        }));
        countdownTimeline.playFromStart();

        startbutton.setVisible(false);
        pauseButton.setVisible(true);
    }
    @FXML
    private void pauseCountdown() {
        if (countdownTimeline != null) {
            countdownTimeline.pause();
            startbutton.setVisible(true);
            pauseButton.setVisible(false);
        }
    }
    @FXML
    public void cliclongbreak(ActionEvent e1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(maincontrol.class.getResource("longbreak.fxml"));
        Stage stage = (Stage)((Node)e1.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent)fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("LongBreak");
        stage.show();
    }
    @FXML
    public void clickpomodoro(ActionEvent e1) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(maincontrol.class.getResource("pomodoro.fxml"));
        Stage stage = (Stage)((Node)e1.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent)fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("FOCUS MODE");
        stage.show();
    }
    public void clickshortbreak(ActionEvent e1) throws IOException {
        if (countdownTimeline != null) {
            countdownTimeline.stop();
        }
        timeSeconds = 15 * 60;

        FXMLLoader fxmlLoader = new FXMLLoader(maincontrol.class.getResource("shortbreak.fxml"));
        Stage stage = (Stage)((Node)e1.getSource()).getScene().getWindow();
        Scene scene = new Scene((Parent)fxmlLoader.load());
        stage.setScene(scene);
        stage.setTitle("FOCUS~POMODORO");
        stage.show();
    }
}