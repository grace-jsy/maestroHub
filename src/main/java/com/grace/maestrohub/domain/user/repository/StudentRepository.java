package com.grace.maestrohub.domain.user.repository;

import com.grace.maestrohub.domain.user.entity.user.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
