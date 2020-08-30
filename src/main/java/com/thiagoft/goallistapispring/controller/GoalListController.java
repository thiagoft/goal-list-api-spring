package com.thiagoft.goallistapispring.controller;

import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.service.GoalListService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PutMapping
    public ResponseEntity<GoalList> update(@RequestBody GoalList goalList) {
        return goalListService.update(goalList);
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
