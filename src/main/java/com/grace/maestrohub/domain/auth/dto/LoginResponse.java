package com.grace.maestrohub.domain.auth.dto;

import com.grace.maestrohub.domain.user.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponse {

    private Long userId;
    private String username;
    private String email;
    private UserRole role;
}
