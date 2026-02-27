package com.grace.maestrohub.domain.user.dto;

import com.grace.maestrohub.domain.user.entity.user.Tutor;
import com.grace.maestrohub.domain.user.entity.user.User;
import com.grace.maestrohub.domain.user.enums.UserRole;
import lombok.Getter;

@Getter
public class SignUpTutorRequest {
    private String email;
    private String password;
    private String username;
    private String phone;
    private String region;

    private String major;
    private int careerYears;
    private String introduction;

    public User toUser() {
        return User.builder()
                .email(email)
                .password(password)
                .username(username)
                .phone(phone)
                .role(UserRole.TUTOR)
                .region(region)
                .build();
    }

    public Tutor toTutor(User user) {
        return new Tutor(user, major, careerYears, introduction);
    }
}
