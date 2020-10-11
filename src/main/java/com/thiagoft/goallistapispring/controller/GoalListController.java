package com.thiagoft.goallistapispring.controller;

import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.service.GoalListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goal-list")
public class GoalListController {

    private final GoalListService goalListService;

    @Autowired
    public GoalListController(GoalListService goalListService) {
        this.goalListService = goalListService;
    }

    @PostMapping
    public ResponseEntity<GoalList> save(@RequestBody GoalList goalList) {
        try {
            return ResponseEntity.ok(goalListService.save(goalList));
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public ResponseEntity<GoalList> update(@RequestBody GoalList goalList) {
        try {
            return ResponseEntity.ok(goalListService.update(goalList));
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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
