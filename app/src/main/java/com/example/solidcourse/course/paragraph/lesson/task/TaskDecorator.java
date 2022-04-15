package com.example.solidcourse.course.paragraph.lesson.task;

public abstract class TaskDecorator extends Task {
    protected Task decorated;

    public TaskDecorator(Task decorated) {
        super();
        this.decorated = decorated;
    }
    // Декорируем обьект класса при вызове вопроса
    public abstract boolean answer(String answer);

    // и притворяемся этим обьектом
    @Override
    public int getScore() {
        return decorated.getScore();
    }

    @Override
    public void setScore(int score) {
        decorated.setScore(score);
    }

    @Override
    public int getMaxScore() {
        return decorated.getMaxScore();
    }

    @Override
    public void setMaxScore(int maxScore) {
        decorated.setMaxScore(maxScore);
    }

    @Override
    public String getText() {
        return decorated.getText();
    }

    @Override
    public void setText(String text) {
        decorated.setText(text);
    }

    @Override
    public void restart() {
        decorated.restart();
    }
}
