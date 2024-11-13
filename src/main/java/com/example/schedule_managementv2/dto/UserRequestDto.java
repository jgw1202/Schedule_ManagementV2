package com.example.schedule_managementv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 요청 DTO
 * - 사용자가 유저 등록 시 전달하는 이름(name)과 이메일(email)을 담고 있는 클래스
 */
@Getter
@RequiredArgsConstructor  // 모든 필드에 대한 생성자를 자동으로 생성하는 Lombok 어노테이션
public class UserRequestDto {

    private final String name;  // 사용자 이름
    private final String email;  // 사용자 이메일
}
