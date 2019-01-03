package main;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Timer;
import java.util.TimerTask;

public class MainViewController {
    @FXML
    private ComboBox<String> levelCombo;
    @FXML
    private Label timeLabel;
    @FXML
    private Button startButton;
    @FXML
    private Label operationLabel;
    @FXML
    private TextField resultTextField;

    private Integer tiempo = 30;


    public void initialize(){
        this.levelCombo.getItems().add("Facil");
        this.levelCombo.getItems().add("Medio");
        this.levelCombo.getItems().add("Dificil");

        this.levelCombo.setPromptText("Elige Nivel");
        this.timeLabel.setText("0");
        this.startButton.setDisable(true);

        this.levelCombo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                startButton.setDisable(false);
            }
        });

        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                final CHGame game = new CHGame();
                timeLabel.setText("30");
                resultTextField.requestFocus();
                countDown();
                game.buildGame(levelCombo.getValue(), MainViewController.this);
                resultTextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.ENTER){
                            game.guessSolution(Integer.parseInt(resultTextField.getText()));
                        }
                    }
                });
            }
        });


    }

    public void setOperationLabel(String operation) {
        this.operationLabel.setText(operation);
    }

    private void countDown(){
        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (tiempo>0){
                            timeLabel.setText(tiempo.toString());
                            tiempo--;
                        }else{
                            timer.cancel();
                        }

                    }
                });
            }
        },0,1000);

    }


}
