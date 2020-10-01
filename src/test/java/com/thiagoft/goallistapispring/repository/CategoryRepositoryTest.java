package com.thiagoft.goallistapispring.repository;

import com.thiagoft.goallistapispring.entity.Category;
import com.thiagoft.goallistapispring.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUserMethod() {
        User user = new User("test_user", "test@test.com", "1234");
        user = userRepository.save(user);

        Category category = new Category("test_category", user);
        category = categoryRepository.saveAndFlush(category);
        assertNotNull(category.getId());

        List<Category> categoryList = categoryRepository.getCategoryByUser(user.getId());
        assertTrue(categoryList.size() > 0);
    }
}
