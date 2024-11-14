package com.example.schedule_managementv2.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 일정 등록 요청 DTO
 * - 사용자가 일정 등록 시 요청 본문에 포함되는 정보를 담고 있는 클래스
 * - 'userId', 'title', 'contents' 필드를 포함하고 있음
 */
@Getter
@RequiredArgsConstructor  // 모든 필드에 대한 생성자를 자동으로 생성하는 Lombok 어노테이션
public class SchedulerRequestDto {

    private final Long userId;  // 사용자 ID, 일정이 어떤 사용자와 연결될지 나타냄

    // 제목 검증 (10자 이하로 제한)
    @NotBlank(message = "제목은 필수 입력 항목입니다.")
    @Size(max = 10, message = "제목은 10자 이하로 입력해주세요.")
    private final String title;  // 일정 제목

    // 내용 검증 (내용은 필수 입력)
    @NotBlank(message = "내용은 필수 입력 항목입니다.")
    private final String contents;  // 일정 상세 내용
}
