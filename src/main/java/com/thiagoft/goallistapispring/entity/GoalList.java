package com.thiagoft.goallistapispring.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class GoalList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goalList")
    private List<Goal> goals;

    public GoalList() {
    }

    public GoalList(String description, User user, List<Goal> goals) {
        this.description = description;
        this.user = user;
        this.goals = goals;
    }

    public GoalList(String description, User user) {
        this.description = description;
        this.user = user;
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

    public List<Goal> getGoals() {
        return goals;
    }

    public void setGoals(List<Goal> goals) {
        this.goals = goals;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoalList goalList = (GoalList) o;
        return Objects.equals(id, goalList.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GoalList{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", goals=" + goals +
                '}';
    }
}
