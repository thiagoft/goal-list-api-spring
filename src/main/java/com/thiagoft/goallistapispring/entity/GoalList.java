package com.thiagoft.goallistapispring.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class GoalList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goalList")
    private Set<Goal> goals = new HashSet<>();

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

    public Set<Goal> getGoals() {
        return goals;
    }

    public void setGoals(Set<Goal> goals) {
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
