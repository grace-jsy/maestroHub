package com.grace.maestrohub.domain.user.controller;

import com.grace.maestrohub.domain.user.dto.SignUpResponseDto;
import com.grace.maestrohub.domain.user.dto.SignUpStudentRequest;
import com.grace.maestrohub.domain.user.dto.SignUpTutorRequest;
import com.grace.maestrohub.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // Sign up - Student
    @PostMapping("/signup/student")
    public ResponseEntity<SignUpResponseDto> signUpStudent(@RequestBody SignUpStudentRequest request) {
        SignUpResponseDto response = userService.signupStudent(request);
        return ResponseEntity.ok(response);
    }

    // Sign up - Tutor
    @PostMapping("/signup/tutor")
    public ResponseEntity<SignUpResponseDto> signUpTutor(@RequestBody SignUpTutorRequest request) {
        SignUpResponseDto response = userService.signupTutor(request);
        return ResponseEntity.ok(response);
    }
}
