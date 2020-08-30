package com.thiagoft.goallistapispring.service;

import com.thiagoft.goallistapispring.entity.Goal;
import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.repository.GoalListRepository;
import com.thiagoft.goallistapispring.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalListService {

    private GoalListRepository goalListRepository;
    private GoalRepository goalRepository;

    @Autowired
    public GoalListService(GoalListRepository goalListRepository, GoalRepository goalRepository) {
        this.goalListRepository = goalListRepository;
        this.goalRepository = goalRepository;
    }

    public ResponseEntity<GoalList> save(GoalList goalList) {
        List<Goal> goalsToSave = goalList.getGoals();
        goalList.setGoals(null);

        try {
            GoalList goaListSaved = goalListRepository.save(goalList);

            if (goalsToSave != null) {
                goalsToSave.forEach(goal -> {
                    goal.setGoalList(goalList);
                    goalRepository.saveAndFlush(goal);
                });
            }

            goaListSaved.setGoals(goalsToSave);

            return ResponseEntity.ok(goaListSaved);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<GoalList> update(GoalList goalList) {
        try {
            GoalList goaListSaved = goalListRepository.saveAndFlush(goalList);
            return ResponseEntity.ok(goaListSaved);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    public void deleteGoalList(GoalList goalList) {
        goalListRepository.delete(goalList);
    }

    public List<GoalList> findByUser(Long userId) {
        return goalListRepository.findByUser(userId);
    }

}
