package com.thiagoft.goallistapispring.repository;

import com.thiagoft.goallistapispring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select category from Category category where category.user.id = :userId")
    public List<Category> getCategoryByUser(@Param("userId") Long userId);
}
