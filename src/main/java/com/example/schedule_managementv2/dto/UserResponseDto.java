package com.example.schedule_managementv2.dto;

import com.example.schedule_managementv2.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * 사용자 응답 DTO
 * - 사용자의 정보(ID, 이름, 이메일, 생성일자, 수정일자)를 담고 있으며,
 *   조회 결과나 생성된 사용자 정보를 클라이언트에게 응답으로 반환할 때 사용
 */
@Getter
@RequiredArgsConstructor  // 모든 필드에 대한 생성자를 자동으로 생성하는 Lombok 어노테이션
public class UserResponseDto {

    private final Long id;  // 사용자 ID
    private final String name;  // 사용자 이름
    private final String email;  // 사용자 이메일
    private final LocalDateTime createdAt;  // 사용자 생성일자
    private final LocalDateTime updatedAt;  // 사용자 수정일자

    /**
     * User 엔티티 객체를 UserResponseDto로 변환하는 메소드
     * @param user 변환할 User 엔티티
     * @return 변환된 UserResponseDto
     */
    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getId(),
                user.getName(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getUpdatedAt());
    }
}
