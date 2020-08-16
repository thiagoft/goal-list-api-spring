package com.thiagoft.goallistapispring.controller;

import com.thiagoft.goallistapispring.entity.Goal;
import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.repository.GoalListRepository;
import com.thiagoft.goallistapispring.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("goal-list")
public class GoalListController {

    private GoalListRepository goalListRepository;
    private GoalRepository goalRepository;

    @Autowired
    public GoalListController(GoalListRepository goalListRepository,GoalRepository goalRepository) {
        this.goalListRepository = goalListRepository;
        this.goalRepository = goalRepository;
    }

    @PostMapping
    public ResponseEntity<GoalList> save(@RequestBody GoalList goalList) {
        List<Goal> goalsToSave = goalList.getGoals();
        goalList.setGoals(null);

        try {
            GoalList goaListSaved = goalListRepository.save(goalList);

            if (goalsToSave != null) {
                goalsToSave.forEach(goal -> {
                    goal.setGoalList(goalList);
                    goalRepository.save(goal);
                });
            }

            goaListSaved.setGoals(goalsToSave);

            return ResponseEntity.ok(goaListSaved);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public List<GoalList> findAll() {
        return goalListRepository.findAll();
    }

    @DeleteMapping
    public void deleteGoalList(@RequestBody GoalList goalList) {
        goalListRepository.delete(goalList);
    }

    @GetMapping("user/{id}")
    public List<GoalList> findByUser(@PathVariable("id") Long userId) {
        return goalListRepository.findByUser(userId);
    }
}
