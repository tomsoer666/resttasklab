package com.restandroid.restandroid.repository;

import com.restandroid.restandroid.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
