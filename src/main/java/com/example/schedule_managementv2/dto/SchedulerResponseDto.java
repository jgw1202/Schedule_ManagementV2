package com.example.schedule_managementv2.dto;


import com.example.schedule_managementv2.entity.Scheduler;
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

    public static SchedulerResponseDto toDto(Scheduler scheduler) {
        return new SchedulerResponseDto(scheduler.getId(), scheduler.getUserName(), scheduler.getTitle(), scheduler.getContents(), scheduler.getCreatedAt(),scheduler.getUpdatedAt());
    }

}
