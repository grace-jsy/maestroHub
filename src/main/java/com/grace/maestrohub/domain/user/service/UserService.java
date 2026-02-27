package com.grace.maestrohub.domain.user.service;

import com.grace.maestrohub.domain.user.dto.SignUpResponseDto;
import com.grace.maestrohub.domain.user.dto.SignUpStudentRequest;
import com.grace.maestrohub.domain.user.dto.SignUpTutorRequest;
import com.grace.maestrohub.domain.user.entity.user.Student;
import com.grace.maestrohub.domain.user.entity.user.Tutor;
import com.grace.maestrohub.domain.user.entity.user.User;
import com.grace.maestrohub.domain.user.repository.StudentRepository;
import com.grace.maestrohub.domain.user.repository.TutorRepository;
import com.grace.maestrohub.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;

    // Sign Up - Student
    @Transactional
    public SignUpResponseDto signupStudent(SignUpStudentRequest request) {

        validateDuplicateEmail(request.getEmail());

        User savedUser = userRepository.save(request.toUser());

        Student student = request.toStudent(savedUser);
        studentRepository.save(student);

        return new SignUpResponseDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getPhone(),
                savedUser.getRegion(),
                savedUser.getRole(),
                savedUser.getStatus()
        );
    }

    // Sign Up - Tutor
    @Transactional
    public SignUpResponseDto signupTutor(SignUpTutorRequest request) {

        validateDuplicateEmail(request.getEmail());

        User savedUser = userRepository.save(request.toUser());

        Tutor tutor = request.toTutor(savedUser);
        tutorRepository.save(tutor);

        return new SignUpResponseDto(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getPhone(),
                savedUser.getRegion(),
                savedUser.getRole(),
                savedUser.getStatus()
        );
    }

    private void validateDuplicateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }
    }
}
