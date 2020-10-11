package com.thiagoft.goallistapispring.service;

import com.thiagoft.goallistapispring.entity.Goal;
import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.entity.User;
import com.thiagoft.goallistapispring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GoalListServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoalListService goalListService;

    @Test
    public void testSavingMethodWithoutGoals() {
        User user = new User("test_user", "test@test.com", "1234");
        user = userRepository.save(user);

        GoalList goalList = new GoalList("NewList", user, null);
        GoalList goalListSaved = goalListService.save(goalList);

        assertNotNull(goalListSaved.getId());
    }

    @Test
    public void testSavingMethodWithGoals() {
        User user = new User("test_user", "test@test.com", "1234");
        user = userRepository.save(user);

        List<Goal> goals = List.of(new Goal("goal1", false, LocalDateTime.now(), false),
                new Goal("goal2", false, LocalDateTime.now(), false));

        GoalList goalList = new GoalList("NewList", user, goals);
        GoalList goalListSaved = goalListService.save(goalList);

        assertNotNull(goalListSaved.getId());
        assertNotNull(goalListSaved.getGoals());
    }

    @Test
    public void testUpdateMethodWithoutGoals() {
        User user = new User("test_user", "test@test.com", "1234");
        user = userRepository.save(user);

        GoalList goalList = new GoalList("NewList", user, null);
        GoalList goalListSaved = goalListService.save(goalList);

        assertNotNull(goalListSaved.getId());

        goalListSaved.setDescription("UpdatedList");

        GoalList updatedGoalList = goalListService.update(goalListSaved);

        assertEquals(updatedGoalList.getDescription(),"UpdatedList");
    }

    @Test
    public void testDeletingMethod() {
        User user = new User("test_user", "test@test.com", "1234");
        user = userRepository.save(user);

        GoalList goalList = new GoalList("NewList", user);
        GoalList goalListSaved = goalListService.save(goalList);

        assertNotNull(goalListSaved.getId());

        goalListService.deleteGoalList(goalListSaved);

        Optional<GoalList> goalListDeleted = goalListService.findById(goalListSaved.getId());
        assertTrue(goalListDeleted.isEmpty());
    }

    @Test
    public void testFindByUserMethod() {
        List<GoalList> goalList = goalListService.findByUser(1L);
        assertNotNull(goalList);
    }
}
