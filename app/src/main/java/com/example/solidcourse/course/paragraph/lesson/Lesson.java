package com.example.solidcourse.course.paragraph.lesson;

import com.example.solidcourse.course.paragraph.lesson.task.Task;

import java.util.List;

public class Lesson {
    private String name;
    private List<Task> tasks;
    private int currentTask;
    private int score;
    private int maxScore;

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
        return tasks.get(currentTask++);
    }

    public boolean hasNext() {
        return currentTask < tasks.size();
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

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void addTask(Task task) {
        tasks.add(task);
        maxScore += task.getMaxScore();
    }
}
