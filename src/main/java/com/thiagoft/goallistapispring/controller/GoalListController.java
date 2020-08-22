package com.thiagoft.goallistapispring.controller;

import com.thiagoft.goallistapispring.entity.Goal;
import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.repository.GoalListRepository;
import com.thiagoft.goallistapispring.repository.GoalRepository;
import com.thiagoft.goallistapispring.service.GoalListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goal-list")
public class GoalListController {

    private GoalListService goalListService;

    @Autowired
    public GoalListController(GoalListService goalListService) {
        this.goalListService = goalListService;
    }

    @PostMapping
    public ResponseEntity<GoalList> save(@RequestBody GoalList goalList) {
        return goalListService.save(goalList);
    }

    @DeleteMapping
    public void deleteGoalList(@RequestBody GoalList goalList) {
        goalListService.deleteGoalList(goalList);
    }

    @GetMapping("user/{id}")
    public List<GoalList> findByUser(@PathVariable("id") Long userId) {
        return goalListService.findByUser(userId);
    }
}
