package com.thiagoft.goallistapispring.entity;

import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    private GoalList goalList;
    private Boolean isRecurrent;
    private LocalDateTime startGoal;
    private Boolean isDone;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Goal(String description, Boolean isRecurrent, LocalDateTime startGoal,
                Boolean isDone) {
        this.description = description;
        this.isRecurrent = isRecurrent;
        this.startGoal = startGoal;
        this.isDone = isDone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GoalList getGoalList() {
        return goalList;
    }

    public void setGoalList(GoalList goalList) {
        this.goalList = goalList;
    }

    public Boolean getRecurrent() {
        return isRecurrent;
    }

    public void setRecurrent(Boolean recurrent) {
        isRecurrent = recurrent;
    }

    public LocalDateTime getStartGoal() {
        return startGoal;
    }

    public void setStartGoal(LocalDateTime startGoal) {
        this.startGoal = startGoal;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goal goal = (Goal) o;
        return Objects.equals(id, goal.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Goal{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", goalList=" + goalList +
                ", isRecurrent=" + isRecurrent +
                ", startGoal=" + startGoal +
                ", isDone=" + isDone +
                ", category=" + category +
                '}';
    }
}
