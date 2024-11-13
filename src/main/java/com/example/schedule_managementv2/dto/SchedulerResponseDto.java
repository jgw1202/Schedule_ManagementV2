package com.example.schedule_managementv2.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class SchedulerResponseDto {

    private final Long id;
    private final String userName;
    private final String title;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

}
