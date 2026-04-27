package com.grace.maestrohub.domain.auth.service;

import com.grace.maestrohub.common.exception.CustomException;
import com.grace.maestrohub.common.exception.ErrorCode;
import com.grace.maestrohub.common.security.jwt.JwtProvider;
import com.grace.maestrohub.domain.auth.dto.LoginRequest;
import com.grace.maestrohub.domain.auth.dto.LoginResponse;
import com.grace.maestrohub.domain.user.dto.SignUpResponse;
import com.grace.maestrohub.domain.user.dto.SignUpStudentRequest;
import com.grace.maestrohub.domain.user.dto.SignUpTutorRequest;
import com.grace.maestrohub.domain.user.entity.user.Student;
import com.grace.maestrohub.domain.user.entity.user.Tutor;
import com.grace.maestrohub.domain.user.entity.user.User;
import com.grace.maestrohub.domain.user.repository.StudentRepository;
import com.grace.maestrohub.domain.user.repository.TutorRepository;
import com.grace.maestrohub.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    @Transactional
    public SignUpResponse signupStudent(SignUpStudentRequest request) {

        validateDuplicateEmail(request.getEmail());

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = request.toUser(encodedPassword);
        User savedUser = userRepository.save(user);

        Student student = request.toStudent(savedUser);
        studentRepository.save(student);

        return new SignUpResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getPhone(),
                savedUser.getRegion(),
                savedUser.getRole(),
                savedUser.getStatus()
        );
    }

    @Transactional
    public SignUpResponse signupTutor(SignUpTutorRequest request) {

        validateDuplicateEmail(request.getEmail());

        String encodedPassword = passwordEncoder.encode(request.getPassword());

        User user = request.toUser(encodedPassword);
        User savedUser = userRepository.save(user);

        Tutor tutor = request.toTutor(savedUser);
        tutorRepository.save(tutor);

        return new SignUpResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getPhone(),
                savedUser.getRegion(),
                savedUser.getRole(),
                savedUser.getStatus()
        );
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(
                () -> new CustomException(ErrorCode.INVALID_LOGIN)
        );

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_LOGIN);
        }

        String accessToken = jwtProvider.generateToken(user);

        return new LoginResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRole(),
                accessToken
        );
    }

    private void validateDuplicateEmail(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new CustomException(ErrorCode.DUPLICATE_EMAIL);
        }
    }
}
