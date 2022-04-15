package com.example.solidcourse.course.paragraph;

import com.example.solidcourse.course.paragraph.lesson.Lesson;

import java.util.List;

public class Paragraph {
    private String name;
    private List<Lesson> lessons;
    private int currentLesson;
    private int score;
    private int maxScore;

    public Paragraph(String name, List<Lesson> lessons) {
        this.name = name;
        setLessons(lessons);
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public boolean answer(String answer) {
        Lesson lesson = lessons.get(currentLesson);
        boolean accepted = lesson.answer(answer);
        if (accepted) {
            score += lesson.getScore();
        }
        return accepted;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
        maxScore = score = 0;
        for (Lesson lesson : lessons) {
            maxScore += lesson.getMaxScore();
            score += lesson.getScore();
        }
    }

    public int getCurrentLesson() {
        return currentLesson;
    }

    public void setCurrentLesson(int currentLesson) {
        this.currentLesson = currentLesson;
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Lesson next() {
        if (currentLesson == lessons.size())
            return null;
        return lessons.get(currentLesson++);
    }

    public boolean hasNext() {
        return currentLesson < lessons.size();
    }

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

}
