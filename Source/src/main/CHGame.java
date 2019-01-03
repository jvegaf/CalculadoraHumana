package main;

import java.util.Timer;
import java.util.TimerTask;

public class CHGame {

    private int gameTime = 30;
    private int operationsResolved = 0;
    private int resultGuessed;

    public void buildGame(String level, MainViewController mainVC){

        switch (level){
            case "Facil":
                startGame(10, mainVC);
                break;
            case "Medio":
                startGame(50, mainVC);
                break;
            case "Dificil":
                startGame(100, mainVC);
                break;
        }
    }

    private void startGame(int range, final MainViewController mainViewController) {


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                gameTime--;
            }
        },0,1000);

        CHOperation op = new CHOperation(range);
        mainViewController.setOperationLabel(op.getOperation());

        /**
         *  should use threads or AsyncTask
         */
        while (operationsResolved < 7){
            if (gameTime>0){
                if (resultGuessed == op.resolveOperation()){
                    operationsResolved++;
                    op = new CHOperation(range, resultGuessed);
                    mainViewController.setOperationLabel(op.getOperation());
                }
            }else{
                playerLoose();
            }
        }
        //playerLoose();
    }

    private void playerLoose() {
        System.out.println("you Loose");
    }

    private void playerWins() {
        System.out.println("You Wins");
    }

    public void guessSolution(int guessed){
        this.resultGuessed = guessed;
    }

}
