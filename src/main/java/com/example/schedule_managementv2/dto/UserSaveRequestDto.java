package com.example.schedule_managementv2.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 사용자 등록 요청 DTO
 * - 사용자 등록 시 클라이언트가 제공하는 이름, 이메일, 비밀번호를 담고 있는 클래스
 */
@Getter
@RequiredArgsConstructor  // 모든 필드에 대한 생성자를 자동으로 생성하는 Lombok 어노테이션
public class UserSaveRequestDto {

    private final String name;  // 사용자 이름
    private final String email;  // 사용자 이메일
    private final String password;  // 사용자 비밀번호
}
