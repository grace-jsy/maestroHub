package com.grace.maestrohub.domain.user.dto;

import com.grace.maestrohub.domain.user.entity.user.Student;
import com.grace.maestrohub.domain.user.entity.user.User;
import com.grace.maestrohub.domain.user.enums.StudentLevel;
import com.grace.maestrohub.domain.user.enums.UserRole;
import lombok.Getter;

@Getter
public class SignUpStudentRequest {
    private String email;
    private String password;
    private String username;
    private String phone;
    private String region;

    private StudentLevel level;
    private String preferredInstrument;
    private String introduction;

    public User toUser() {
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .phone(phone)
                .role(UserRole.STUDENT)
                .region(region)
                .build();
    }

    public Student toStudent(User user) {
        return new Student(user, level, preferredInstrument, introduction);
    }
}
