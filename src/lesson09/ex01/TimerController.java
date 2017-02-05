package lesson09.ex01;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by eriol4ik on 28/01/2017.
 */
public class TimerController {
    @FXML
    private Label timerLbl;
    @FXML
    private Button startButton;
    @FXML
    private Button pauseButton;

    private int counter;

    Thread thread;

    public void initialize() {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                startButton.setDisable(true);
                counter = Integer.parseInt(timerLbl.getText());
                while (counter < 10) {
                    try {
                        thread.sleep(1000);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                timerLbl.setText(Integer.toString(counter++));
                            }
                        });

                    } catch (InterruptedException e) {
                        thread.interrupt();
                    }
                }
                startButton.setDisable(false);
            }
        });
        thread.setDaemon(true);
    }

    @FXML
    public void startTimer() {
            thread.start();
    }

    @FXML
    public void pauseTimer() {
        thread.interrupt();
        startButton.setDisable(false);
        pauseButton.setDisable(true);
    }
}
