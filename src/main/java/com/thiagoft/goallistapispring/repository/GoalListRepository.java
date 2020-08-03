package com.thiagoft.goallistapispring.repository;

import com.thiagoft.goallistapispring.entity.GoalList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalListRepository extends JpaRepository<GoalList, Long> {
}
