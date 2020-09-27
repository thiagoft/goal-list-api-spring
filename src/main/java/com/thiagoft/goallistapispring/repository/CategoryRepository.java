package com.thiagoft.goallistapispring.repository;

import com.thiagoft.goallistapispring.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
