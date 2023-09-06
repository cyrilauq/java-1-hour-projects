package org.example.presenter;

import org.example.domain.Date;
import org.example.domain.Time;
import org.example.views.TimerViewInterface;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class TimerPresenter implements TimerPresenterInterface {
    private TimerViewInterface view;

    public TimerPresenter() {
    }

    @Override
    public void setView(TimerViewInterface view) {
        this.view = view;
    }

    @Override
    public Time getTime() {
        final LocalDateTime now = LocalDateTime.now();
        return new Time(now.getHour(), now.getMinute(), now.getSecond());
    }

    @Override
    public Date getDate() {
        final LocalDateTime now = LocalDateTime.now();
        final String dayName =now.getDayOfWeek().name();
        return new Date(
                dayName.charAt(0) + dayName.substring(1).toLowerCase(),
                now.getMonth().name(),
                now.getYear());
    }
}
