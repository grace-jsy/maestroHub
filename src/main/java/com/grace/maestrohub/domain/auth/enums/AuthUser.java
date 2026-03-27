package com.grace.maestrohub.domain.auth.enums;

public record AuthUser(
        Long userId,
        String email,
        String role
) {
}
