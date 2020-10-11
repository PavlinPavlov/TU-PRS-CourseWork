package bg.subscriber.model;

import java.time.OffsetDateTime;
import java.util.List;

public class Course {

    private String name;
    private int credits;
    private OffsetDateTime examDate;
    private List<String> exerciseDescriptions;

    public Course() {
    }

    public Course(String name, int credits, OffsetDateTime examDate) {
        this.name = name;
        this.credits = credits;
        this.examDate = examDate;
    }

    public Course(String name, int credits, OffsetDateTime examDate, List<String> exerciseDescriptions) {
        this.name = name;
        this.credits = credits;
        this.examDate = examDate;
        this.exerciseDescriptions = exerciseDescriptions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public OffsetDateTime getExamDate() {
        return examDate;
    }

    public void setExamDate(OffsetDateTime examDate) {
        this.examDate = examDate;
    }

    public List<String> getExerciseDescriptions() {
        return exerciseDescriptions;
    }

    public void setExerciseDescriptions(List<String> exerciseDescriptions) {
        this.exerciseDescriptions = exerciseDescriptions;
    }
}
