package com.example.solidcourse.course;

import com.example.solidcourse.course.paragraph.Paragraph;

import java.util.List;

public class Course {
    private String name;
    private String author;
    private List<Paragraph> paragraphs;
    private int score;
    private int maxScore;
    private int currentParagraph;

    public Course(String name, String author, List<Paragraph> paragraphs) {
        this.name = name;
        this.author = author;
        setParagraphs(paragraphs);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
        maxScore = score = 0;
        for (Paragraph paragraph : paragraphs) {
            score += paragraph.getScore();
            maxScore += paragraph.getMaxScore();
        }
    }

    public void addParagraph(Paragraph paragraph) {
        paragraphs.add(paragraph);
        score += paragraph.getScore();
        maxScore += paragraph.getMaxScore();
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCurrentParagraph(int currentParagraph) {
        this.currentParagraph = currentParagraph;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public int getScore() {
        return score;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public int getCurrentParagraph() {
        return currentParagraph;
    }

    public Paragraph next() {
        if (currentParagraph == paragraphs.size())
            return null;
        return paragraphs.get(currentParagraph++);
    }

    public boolean hasNext() {
        return currentParagraph < paragraphs.size();
    }

}
