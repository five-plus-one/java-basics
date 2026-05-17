package com.fiveplusone.homework08.task05;

public class ScoreRecord {
    private String studentId;
    private String name;
    private double score;

    public ScoreRecord(String studentId, String name, double score) {
        this.studentId = studentId;
        this.name = name;
        this.score = score;
    }

    // Getter 和 Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return studentId + " " + name + " " + score;
    }
}