package com.project.SkillSystem.Exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_KEY(1001, "Uncategorized error", HttpStatus.BAD_REQUEST),
    USER_EXISTED(1002, "User existed", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    PROFILE_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    CERTIFICATE_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    EDUCATION_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    CATEGORY_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    WORK_EXPERIENCE_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    SKILL_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    LANGUAGE_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    PROJECT_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You do not have permission", HttpStatus.FORBIDDEN),
    ;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

    private int code;
    private String message;
    private HttpStatusCode statusCode;
}
