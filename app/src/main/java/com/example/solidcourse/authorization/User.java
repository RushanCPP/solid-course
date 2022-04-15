package com.example.solidcourse.authorization;

import com.example.solidcourse.course.Course;

import java.util.List;

public class User {
    private List<Course> courses;
    private int score;

    public User(List<Course> courses) {
        this.courses = courses;
        update();
    }

    public void update() {
        for (Course course: courses) {
            score += course.getScore();
        }
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public int getScore() {
        return score;
    }
}
