package com.grace.maestrohub.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_404", "User not found"),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, "COMMON_400", "Invalid request"),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_500", "Internal server error");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
