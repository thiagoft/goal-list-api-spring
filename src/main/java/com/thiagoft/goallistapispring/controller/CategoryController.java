package com.thiagoft.goallistapispring.controller;

import com.thiagoft.goallistapispring.entity.Category;
import com.thiagoft.goallistapispring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoryController {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("user/{userId}")
    public List<Category> getCategoryByUser(@PathParam("userId") Long userId) {
        return categoryRepository.getCategoryByUser(userId);
    }

    @PostMapping
    public Category save(@RequestBody Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathParam("id") Long id) {
        categoryRepository.delete(new Category(id));
    }

    @PatchMapping
    public Category update(@RequestBody Category category) {
        return categoryRepository.saveAndFlush(category);
    }
}
