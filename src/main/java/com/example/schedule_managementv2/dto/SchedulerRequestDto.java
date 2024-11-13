package com.example.schedule_managementv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class SchedulerRequestDto {

    private final Long userId;
    private final String title;
    private final String contents;

    @Override
    public String toString() {
        return "SchedulerRequestDto{" +
                "userId=" + userId +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                '}';
    }
}

