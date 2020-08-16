package com.thiagoft.goallistapispring.controller;

import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.entity.User;
import com.thiagoft.goallistapispring.repository.GoalListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("goal-list")
public class GoalListController {

    private GoalListRepository goalListRepository;

    @Autowired
    public GoalListController(GoalListRepository goalListRepository) {
        this.goalListRepository = goalListRepository;
    }

    @PostMapping
    public GoalList save(@RequestBody GoalList goalList) {
        return goalListRepository.save(goalList);
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
