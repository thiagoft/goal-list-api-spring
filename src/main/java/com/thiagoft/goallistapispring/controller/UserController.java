package com.thiagoft.goallistapispring.controller;

import com.thiagoft.goallistapispring.entity.User;
import com.thiagoft.goallistapispring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("{id}")
    public User findById(@PathVariable("id") Long id) {
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return userRepository.save(user);
    }
}
