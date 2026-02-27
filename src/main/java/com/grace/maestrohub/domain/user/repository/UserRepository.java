package com.grace.maestrohub.domain.user.repository;

import com.grace.maestrohub.domain.user.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
