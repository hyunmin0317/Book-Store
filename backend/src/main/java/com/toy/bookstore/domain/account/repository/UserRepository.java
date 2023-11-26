package com.toy.bookstore.domain.account.repository;

import com.toy.bookstore.domain.account.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getByUsername(String username);
    boolean existsByUsername(String username);
}
