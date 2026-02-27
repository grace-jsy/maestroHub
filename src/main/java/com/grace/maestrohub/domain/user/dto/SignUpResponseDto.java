package com.grace.maestrohub.domain.user.dto;

import com.grace.maestrohub.domain.user.enums.Status;
import com.grace.maestrohub.domain.user.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpResponseDto {

    private Long userId;
    private String username;
    private String email;
    private String phone;
    private String region;
    private UserRole role;
    private Status status;
}
