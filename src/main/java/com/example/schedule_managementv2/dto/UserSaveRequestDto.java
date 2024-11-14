package com.example.schedule_managementv2.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


/**
 * 사용자 등록 요청 DTO
 * - 사용자 등록 시 클라이언트가 제공하는 이름, 이메일, 비밀번호를 담고 있는 클래스
 */
@Getter
@RequiredArgsConstructor  // 모든 필드에 대한 생성자를 자동으로 생성하는 Lombok 어노테이션
public class UserSaveRequestDto {

    // 이름 검증 (4글자 이상, 20글자 이하)
    @NotBlank(message = "이름은 필수 입력 항목입니다.")
    @Size(min = 2, max = 20, message = "이름은 2자 이상 20자 이내로 입력해주세요.")
    private final String name;  // 사용자 이름

    // 이메일 검증 (NotBlank: 공백 불허, Email: 이메일 형식 확인)
    @NotBlank(message = "이메일은 필수 입력 항목입니다.")
    @Email(message = "유효한 이메일 형식을 입력해주세요.")
    private final String email;  // 사용자 이메일

    // 비밀번호 검증 (8글자 이상, 영문 + 숫자 조합)
    @NotBlank(message = "비밀번호는 필수 입력 항목입니다.")
    @Size(min = 6, max = 20, message = "비밀번호는 6자 이상 20자 이하로 입력해주세요.")
    private final String password;  // 사용자 비밀번호
}
