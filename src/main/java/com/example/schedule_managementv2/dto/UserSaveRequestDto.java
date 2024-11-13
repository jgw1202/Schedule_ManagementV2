package com.example.schedule_managementv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class UserSaveRequestDto {

    private final String name;
    private final String email;
    private final String password;

}
