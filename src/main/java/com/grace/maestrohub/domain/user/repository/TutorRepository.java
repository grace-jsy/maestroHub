package com.grace.maestrohub.domain.user.repository;

import com.grace.maestrohub.domain.user.entity.user.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
}
