package com.example.solidcourse.course.paragraph.lesson.task;

public abstract class Task {
    protected int score;
    protected int maxScore;
    protected String text;

    public Task(int maxScore, String text) {
        this.maxScore = maxScore;
        this.text = text;
        score = 0;
    }

    protected Task() {};

    // геттеры и сеттеры класса
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // ответ на разные задачи происходит разными способами
    abstract public boolean answer(String answer);

    public void restart() {
        this.score = 0;
    }
}
