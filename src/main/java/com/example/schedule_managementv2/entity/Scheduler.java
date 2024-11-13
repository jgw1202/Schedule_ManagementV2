package com.example.schedule_managementv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 일정 엔티티
 * - 사용자와 연결된 일정 정보를 저장하는 엔티티 클래스
 * - 사용자와 다대일 관계를 맺고 있으며, 일정 제목과 내용 등의 필드를 포함
 */
@Entity
@Table(name = "scheduler")  // 해당 엔티티는 "scheduler"라는 테이블에 매핑됨
@NoArgsConstructor  // 기본 생성자를 자동으로 생성
@Getter  // Getter 메소드들을 자동으로 생성하는 Lombok 어노테이션
public class Scheduler extends BaseEntity {

    @Id  // 이 필드는 해당 엔티티의 기본 키로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동으로 증가하는 값으로 설정
    private Long id;  // 일정의 고유 ID

    @ManyToOne  // 다대일 관계: 여러 일정이 하나의 사용자에 속함
    @JoinColumn(name = "user_id", nullable = false)  // user_id라는 컬럼으로 사용자와 관계를 설정
    private User user;  // 해당 일정을 소유한 사용자

    @Column(nullable = false)  // 일정 제목은 필수 항목
    private String title;  // 일정 제목

    @Column(columnDefinition = "longtext")  // 일정 내용은 길이가 긴 텍스트로 설정
    private String contents;  // 일정 상세 내용

    /**
     * 생성자: 사용자, 제목, 내용으로 일정을 생성하는 생성자
     * @param user 일정 소유자
     * @param title 일정 제목
     * @param contents 일정 내용
     */
    public Scheduler(User user, String title, String contents) {
        this.user = user;
        this.title = title;
        this.contents = contents;
    }

    /**
     * 일정 수정 메소드
     * @param title 수정할 제목
     * @param contents 수정할 내용
     */
    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
