package com.szmolke.coderslab.submissions.model;

import java.time.LocalDateTime;

public class Solution {
    private int id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String description;
    private User author;
    private Exercise exercise;

    public Solution() {
    }

    public Solution(LocalDateTime createdAt, LocalDateTime updatedAt, String description, User author, Exercise exercise) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.description = description;
        this.author = author;
        this.exercise = exercise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    @Override
    public String toString() {
        return "Solution{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", description='" + description + '\'' +
                ", author=" + author +
                ", exercise=" + exercise +
                '}';
    }
}
