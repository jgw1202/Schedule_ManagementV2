package com.example.schedule_managementv2.dto;

import com.example.schedule_managementv2.entity.Scheduler;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * 일정 응답 DTO
 * - 일정을 조회하거나 등록/수정 후 클라이언트에게 응답으로 반환되는 정보를 담고 있는 클래스
 * - 일정의 ID, 사용자 ID, 제목, 내용, 생성일자 및 수정일자를 포함
 */
@Getter
@RequiredArgsConstructor  // 모든 필드에 대한 생성자를 자동으로 생성하는 Lombok 어노테이션
public class SchedulerResponseDto {

    private final Long id;  // 일정 ID
    private final Long userId;  // 해당 일정이 속한 사용자 ID
    private final String title;  // 일정 제목
    private final String contents;  // 일정 상세 내용
    private final LocalDateTime createdAt;  // 일정 생성일자
    private final LocalDateTime updatedAt;  // 일정 수정일자

    /**
     * Scheduler 엔티티 객체를 SchedulerResponseDto로 변환하는 메소드
     * @param scheduler 변환할 Scheduler 엔티티
     * @return 변환된 SchedulerResponseDto
     */
    public static SchedulerResponseDto toDto(Scheduler scheduler) {
        return new SchedulerResponseDto(scheduler.getId(),
                scheduler.getUser().getId(),
                scheduler.getTitle(),
                scheduler.getContents(),
                scheduler.getCreatedAt(),
                scheduler.getUpdatedAt());
    }
}
