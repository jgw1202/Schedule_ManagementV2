package com.example.schedule_managementv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
/**
 * 로그인 요청 DTO
 * - 사용자가 로그인 요청 시 요청 본문에 포함되는 정보를 담고 있는 클래스
 * - 'email', 'password' 필드를 포함하고 있음
 */
@Getter
@RequiredArgsConstructor
public class LoginRequestDto {

    private final String email;
    private final String password;

}
