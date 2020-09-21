package com.thiagoft.goallistapispring.service;

import com.thiagoft.goallistapispring.entity.Goal;
import com.thiagoft.goallistapispring.entity.GoalList;
import com.thiagoft.goallistapispring.entity.User;
import com.thiagoft.goallistapispring.repository.GoalListRepository;
import com.thiagoft.goallistapispring.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class GoalListServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GoalListRepository goalListRepository;

    @Test
    public void testSavingMethodWithoutGoals() {
        User user = new User("test_user", "test@test.com", "1234");
        user = userRepository.save(user);

        GoalList goalList = new GoalList("NewList", user, null);
        GoalList goalListSaved = goalListRepository.save(goalList);

        assertNotNull(goalListSaved.getId());
    }

    @Test
    public void testSavingMethodsWithGoals() {
        User user = new User("test_user", "test@test.com", "1234");
        user = userRepository.save(user);

        List<Goal> goals = List.of(new Goal("goal1", false, LocalDateTime.now(),
                LocalDateTime.now(), false),
                new Goal("goal2", false, LocalDateTime.now(),
                        LocalDateTime.now(), false));

        GoalList goalList = new GoalList("NewList", user, goals);
        GoalList goalListSaved = goalListRepository.save(goalList);

        assertNotNull(goalListSaved.getId());
        assertNotNull(goalListSaved.getGoals());
    }

    @Test
    public void testFindByUserMethod() {
        List<GoalList> goalList = goalListRepository.findByUser(1l);
        assertNotNull(goalList);
    }
}
