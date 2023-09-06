package org.example.presenter;

import org.example.domain.Date;
import org.example.domain.Time;
import org.example.views.TimerViewInterface;

public interface TimerPresenterInterface {

    void setView(TimerViewInterface view);

    Time getTime();

    Date getDate();

}
