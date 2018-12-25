package main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class MainViewController {
    @FXML
    ComboBox<String> levelCombo;
    @FXML
    Label timeLabel;
    @FXML
    Button startButton;
    @FXML
    Label operationLabel;



    public void initialize(){
        this.levelCombo.getItems().add("Facil");
        this.levelCombo.getItems().add("Medio");
        this.levelCombo.getItems().add("Dificil");

        this.levelCombo.setPromptText("Elige Nivel");
        this.timeLabel.setText("0");

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                CHGame.startGame(levelCombo.getValue());
            }
        });
    }




}
