package com.example.schedule_managementv2.dto;

import com.example.schedule_managementv2.entity.Scheduler;
import com.example.schedule_managementv2.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UserResponseDto {

    private final Long id;
    private final String name;
    private final String email;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt(),user.getUpdatedAt());
    }
}
