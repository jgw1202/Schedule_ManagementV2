package com.example.schedule_managementv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 사용자 엔티티
 * - 사용자 정보를 저장하는 엔티티 클래스
 * - 사용자의 이름, 이메일, 비밀번호 등의 필드를 포함
 */
@Entity
@Table(name = "user")  // 해당 엔티티는 "user"라는 테이블에 매핑됨
@NoArgsConstructor  // 기본 생성자를 자동으로 생성
@Getter  // Getter 메소드들을 자동으로 생성하는 Lombok 어노테이션
public class User extends BaseEntity {

    @Id  // 이 필드는 해당 엔티티의 기본 키로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 자동으로 증가하는 값으로 설정
    private Long id;  // 사용자 고유 ID

    @Column(nullable = false, unique = true)  // 사용자 이름은 필수 항목이며 유일해야 함
    private String name;  // 사용자 이름

    @Column(nullable = false, unique = true)  // 사용자 이메일은 필수 항목이며 유일해야 함
    private String email;  // 사용자 이메일

    @Column(nullable = false)  // 사용자 비밀번호는 필수 항목
    private String password;  // 사용자 비밀번호

    /**
     * 생성자: 이름, 이메일, 비밀번호로 사용자 생성
     * @param name 사용자 이름
     * @param email 사용자 이메일
     * @param password 사용자 비밀번호
     */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
