package com.example.solidcourse;

import org.junit.Test;

import com.example.solidcourse.course.paragraph.Paragraph;
import com.example.solidcourse.course.paragraph.lesson.Lesson;
import com.example.solidcourse.course.paragraph.lesson.task.Task;
import com.example.solidcourse.course.paragraph.lesson.task.TimeOutTask;

import java.util.ArrayList;
import java.time.Duration;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    static class TempTask extends Task {
        public TempTask(int maxScore, String text) {
            super(maxScore, text);
        }
        public TempTask() { super(1, ""); }
        @Override
        public boolean answer(String answer) {
            score = maxScore;
            return true;
        }
    }

    @Test
    public void testLessonAnswer() {
        Lesson lesson = new Lesson("Да", new ArrayList<>());
        lesson.addTask(new TempTask(10, ""));
        lesson.answer("");
        assert lesson.getScore() == 10;
    }
    @Test
    public void testLessonAdd() {
        Lesson lesson = new Lesson("Да", new ArrayList<>());
        lesson.addTask(new TempTask(10, ""));
        assert lesson.getTasks().size() == 1;
        lesson.addTask(new TempTask(11, ""));
        assert lesson.getTasks().size() == 2;
        assert lesson.getMaxScore() == 21;
        assert lesson.getScore() == 0;
        lesson.answer("");
        lesson.next();
        lesson.answer("");
        assert lesson.getScore() == lesson.getMaxScore();
    }

    @Test
    public void testLessonNext() {
        Lesson lesson = new Lesson("Да", new ArrayList<>());
        for (int i = 0; i < 5; ++i) {
            lesson.addTask(new TempTask(10, ""));
        }
        int count = 0;
        Task task = lesson.next();
        while (lesson.hasNext()) {
            count++;
            task = lesson.next();
        }
        assert count != lesson.getTasks().size();
    }

    @Test
    public void timeOutTestLesson() throws InterruptedException {
        {   // first block
            Lesson lesson = new Lesson("Name", new ArrayList<>());
            lesson.addTask(new TimeOutTask(new TempTask(4, ""), Duration.ofSeconds(1)));
            lesson.answer("");
            assert lesson.getScore() == lesson.getMaxScore();
        }
        {   // second block
            Lesson lesson = new Lesson("", new ArrayList<>());
            lesson.addTask(new TimeOutTask(new TempTask(4, ""), Duration.ofSeconds(1)));
            Thread.sleep(2000);
            lesson.answer("");
            assert lesson.getScore() == 0;
            lesson.getTasks().get(0).restart();
            lesson.answer("");
            assert lesson.getScore() == lesson.getMaxScore();
        }
    }

    @Test
    public void timeOutTestTask() throws InterruptedException {
        Duration duration = Duration.ofSeconds(1);
        assert duration.getSeconds() == 1;
        {   // first block
            Task task = new TimeOutTask(new TempTask(4, ""), duration);
            task.answer("");
            assert task.getScore() == task.getMaxScore();
        }
        {   // second block
            Task task = new TimeOutTask(new TempTask(4, ""), Duration.ofSeconds(1));
            Thread.sleep(2000);
            task.answer("");
            assert task.getScore() == 0;
            task.restart();
            task.answer("");
            assert task.getScore() == task.getMaxScore();
        }
    }

    @Test
    public void testAddTask() {
        Lesson lesson = new Lesson("1.1", new ArrayList<>());
        lesson.addTask(new TempTask());
        lesson.addTask(new TempTask());
        lesson.addTask(new TempTask());
        assert lesson.getTasks().size() == 3;
    }

    @Test
    public void testAddLesson() {
        Lesson lesson = new Lesson("1.1", new ArrayList<>());
        lesson.addTask(new TempTask());
        lesson.addTask(new TempTask());
        lesson.addTask(new TempTask());
        assert lesson.getTasks().size() == 3;
        Paragraph paragraph = new Paragraph("yes", new ArrayList<>());
        paragraph.addLesson(lesson);

        lesson = new Lesson("1.2", new ArrayList<>());
        lesson.addTask(new TempTask());
        lesson.addTask(new TempTask());
        lesson.addTask(new TempTask());
        paragraph.addLesson(lesson);

        assert paragraph.getLessons().size() == 2;
        lesson = paragraph.next();
        int i = 0;
        while (paragraph.hasNext()) {
            assert lesson.getName().equals(String.format("1.%d", i + 1));
            lesson = paragraph.next();
        }
    }
}