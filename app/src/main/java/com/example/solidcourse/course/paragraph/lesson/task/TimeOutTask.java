package com.example.solidcourse.course.paragraph.lesson.task;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDateTime;

public class TimeOutTask extends TaskDecorator {
    private Duration duration;
    private LocalDateTime beginDate;

    public TimeOutTask(Task decorated, Duration duration) {
        super(decorated);
        this.duration = duration;
        beginDate = LocalDateTime.now();
    }

    @Override
    public boolean answer(String answer) {
        //  now - duration > beginDate
        if (beginDate.isBefore(LocalDateTime.now().minus(duration))) {
            return false;
        }
        return decorated.answer(answer);
    }

    @Override
    public void restart() {
        beginDate = LocalDateTime.now();
        super.restart();
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public LocalDateTime getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }
}
