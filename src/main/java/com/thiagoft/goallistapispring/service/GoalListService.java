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
import java.util.Optional;

@Service
public class GoalListService {

    private GoalListRepository goalListRepository;
    private GoalRepository goalRepository;

    @Autowired
    public GoalListService(GoalListRepository goalListRepository, GoalRepository goalRepository) {
        this.goalListRepository = goalListRepository;
        this.goalRepository = goalRepository;
    }

    public GoalList save(GoalList goalList) {
        List<Goal> goalsToSave = goalList.getGoals();
        goalList.setGoals(null);

        GoalList goaListSaved = goalListRepository.save(goalList);

        if (goalsToSave != null) {
            goalsToSave.forEach(goal -> {
                goal.setGoalList(goalList);
                goalRepository.saveAndFlush(goal);
            });
        }

        goaListSaved.setGoals(goalsToSave);

        return goaListSaved;

    }

    public GoalList update(GoalList goalList) {
        return goalListRepository.saveAndFlush(goalList);
    }

    public void deleteGoalList(GoalList goalList) {
        goalListRepository.delete(goalList);
    }

    public List<GoalList> findByUser(Long userId) {
        return goalListRepository.findByUser(userId);
    }

    public Optional<GoalList> findById(Long id) {
        return goalListRepository.findById(id);
    }

}
