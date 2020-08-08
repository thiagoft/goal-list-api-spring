package com.thiagoft.goallistapispring.repository;

import com.thiagoft.goallistapispring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
