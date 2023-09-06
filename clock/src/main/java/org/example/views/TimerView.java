package org.example.views;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.example.domain.Date;
import org.example.domain.Time;
import org.example.presenter.TimerPresenterInterface;

import javax.swing.*;
import javax.swing.text.Position;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerView extends Scene implements TimerViewInterface {
    private final TimerPresenterInterface presenter;

    private final Label dateTxt = new Label();
    private final Label dateMonthTxt = new Label();
    private final Label dateYearTxt = new Label();
    private final HBox datePnl = new HBox(); {
        datePnl.getChildren().addAll(dateTxt);
        datePnl.setAlignment(Pos.TOP_CENTER);
    }

    private final Label timeHoursTxt = new Label();
    private final Label timeMinutesTxt = new Label();
    private final Label timeSecondesTxt = new Label();
    private final HBox timePnl = new HBox(); {
        timePnl.getChildren().addAll(timeHoursTxt, new Label(":"), timeMinutesTxt, new Label(":"), timeSecondesTxt);
        timePnl.setAlignment(Pos.TOP_CENTER);
    }

    private final VBox rootPnl = new VBox(); {
        rootPnl.getChildren().addAll(new Label("JavaFX Clock"), new Label("Date"), datePnl, new Label("Time"), timePnl);
        rootPnl.setAlignment(Pos.TOP_CENTER);
    }

    public TimerView(TimerPresenterInterface presenter) {
        super(new Pane(), 400, 300);

        this.presenter = presenter;
        presenter.setView(this);
    }

    public void start() {
        setRoot(rootPnl);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            final Time now = presenter.getTime();
            displayTime(now.getHours(), now.getMinutes(), now.getSeconds());
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        Timeline dayline = new Timeline(new KeyFrame(Duration.seconds(1), ev -> {
            final Date now = presenter.getDate();
            displayDate(now.getDay(), now.getMonth(), now.getYear());
        }));
        dayline.setCycleCount(Animation.INDEFINITE);
        dayline.play();
    }

    @Override
    public void displayDate(String day, String month, int year) {
        dateTxt.setText(String.format("%s %s %d", day, month, year));
    }

    @Override
    public void displayTime(int hours, int minutes, int seconds) {
        timeHoursTxt.setText(String.valueOf(hours));
        timeMinutesTxt.setText(String.valueOf(minutes));
        timeSecondesTxt.setText(String.valueOf(seconds));
    }
}
