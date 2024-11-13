package com.example.schedule_managementv2.controller;

import com.example.schedule_managementv2.dto.*;
import com.example.schedule_managementv2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 일정 등록
    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        UserResponseDto userResponseDto = userService.save(
                userSaveRequestDto.getName(),
                userSaveRequestDto.getEmail(),
                userSaveRequestDto.getPassword());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }


}
