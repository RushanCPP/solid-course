package com.example.solidcourse.course.paragraph.lesson;

import com.example.solidcourse.course.paragraph.lesson.task.Task;

import java.util.List;

public class Lesson {
    protected String name;
    protected List<Task> tasks;
    protected int currentTask;
    protected int score;
    protected int maxScore;

    public Lesson(String name, List<Task> tasks) {
        this.name = name;
        this.currentTask = 0;
        this.setTasks(tasks);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Task next() {
        if (currentTask == tasks.size())
            return null;
        ++currentTask;
        return tasks.get(currentTask);
    }

    public boolean answer(String answer) {
        Task task = tasks.get(currentTask);
        boolean accepted = task.answer(answer);
        if (accepted) {
            score += task.getScore();
        }
        return accepted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        score = 0;
        maxScore = 0;
        for (Task task : tasks) {
            score += task.getScore();
            maxScore += task.getMaxScore();
        }
    }

    public int getCurrentTask() {
        return currentTask;
    }

    public void setCurrentTask(int currentTask) {
        this.currentTask = currentTask;
    }
}
