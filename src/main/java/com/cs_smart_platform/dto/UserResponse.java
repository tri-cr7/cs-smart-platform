package com.cs_smart_platform.dto;

import java.time.LocalDateTime;

import com.cs_smart_platform.model.User;

public record UserResponse(
    Long id,
    String username,
    String email,
    String fullName,
    LocalDateTime createdAt
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
            user.getId(),
            user.getUsername(),
            user.getEmail(),
            user.getFullName(),
            user.getCreatedAt()
        );
    }
}
