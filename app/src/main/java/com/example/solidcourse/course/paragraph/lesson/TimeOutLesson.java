package com.example.solidcourse.course.paragraph.lesson;

import com.example.solidcourse.course.paragraph.lesson.task.Task;

import java.util.List;

public class TimeOutLesson extends Lesson {
    private long begin;
    private long duration;

    public TimeOutLesson(String name, List<Task> tasks, long durationInMills) {
        super(name, tasks);
        begin = System.currentTimeMillis();
        duration = durationInMills;
    }

    @Override
    public boolean answer(String answer) {
        if (System.currentTimeMillis() - duration > begin) {
            return false;
        }
        return super.answer(answer);
    }

    public long getBegin() {
        return begin;
    }

    public void setBegin(long begin) {
        this.begin = begin;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void restart() {
        setBegin(System.currentTimeMillis());
    }
}
