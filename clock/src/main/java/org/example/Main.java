package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.presenter.TimerPresenter;
import org.example.views.TimerView;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TimerView mainWindow = new TimerView(new TimerPresenter());
        mainWindow.start();

        stage.setTitle("JAVA FX Timer");
        stage.setResizable(false);
        stage.setX(100);
        stage.setY(100);

        stage.setScene(mainWindow);

        stage.show();

    }
}