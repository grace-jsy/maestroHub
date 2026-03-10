package com.grace.maestrohub.domain.auth.controller;

import com.grace.maestrohub.domain.auth.dto.LoginRequest;
import com.grace.maestrohub.domain.auth.dto.LoginResponse;
import com.grace.maestrohub.domain.auth.service.AuthService;
import com.grace.maestrohub.domain.user.dto.SignUpResponse;
import com.grace.maestrohub.domain.user.dto.SignUpStudentRequest;
import com.grace.maestrohub.domain.user.dto.SignUpTutorRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup/student")
    public SignUpResponse signupStudent(@Valid @RequestBody SignUpStudentRequest request) {
        return authService.signupStudent(request);
    }

    @PostMapping("/signup/tutor")
    public SignUpResponse signupTutor(@Valid @RequestBody SignUpTutorRequest request) {
        return authService.signupTutor(request);
    }

    @PostMapping("/login")
    private LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);

    }
}
