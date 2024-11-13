package com.example.schedule_managementv2.controller;

import com.example.schedule_managementv2.dto.*;
import com.example.schedule_managementv2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // 유저 등록
    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto) {

        UserResponseDto userResponseDto = userService.save(
                userSaveRequestDto.getName(),
                userSaveRequestDto.getEmail(),
                userSaveRequestDto.getPassword());

        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }
    // 유저 전체 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {

        List<UserResponseDto> userResponseDtoList = userService.findAll();

        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

}
