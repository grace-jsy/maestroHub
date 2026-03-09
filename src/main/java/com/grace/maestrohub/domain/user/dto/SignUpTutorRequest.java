package com.grace.maestrohub.domain.user.dto;

import com.grace.maestrohub.domain.user.entity.user.Tutor;
import com.grace.maestrohub.domain.user.entity.user.User;
import com.grace.maestrohub.domain.user.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignUpTutorRequest {

    @NotBlank(message = "Invalid email format")
    @Email(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    private String password;

    @NotBlank(message = "Username is required")
    private String username;

    @NotBlank(message = "Phone is required")
    private String phone;

    private String region;
    private String major;
    private int careerYears;
    private String introduction;

    public User toUser(String encodedPassword) {
        return User.builder()
                .email(email)
                .password(encodedPassword)
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
