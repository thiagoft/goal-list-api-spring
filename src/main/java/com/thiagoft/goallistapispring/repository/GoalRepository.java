package com.thiagoft.goallistapispring.repository;

import com.thiagoft.goallistapispring.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}
