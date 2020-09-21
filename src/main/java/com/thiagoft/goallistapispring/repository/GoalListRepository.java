package com.thiagoft.goallistapispring.repository;

import com.thiagoft.goallistapispring.entity.GoalList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GoalListRepository extends JpaRepository<GoalList, Long> {
    @Query("SELECT goalList FROM GoalList goalList WHERE goalList.user.id = :userId")
    List<GoalList> findByUser(Long userId);
}
