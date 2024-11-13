package com.example.schedule_managementv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class SchedulerRequestDto {

    private final String userName;
    private final String title;
    private final String contents;

}
