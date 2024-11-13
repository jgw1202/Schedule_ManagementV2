package com.example.schedule_managementv2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 모든 엔티티의 공통 속성을 포함하는 기본 엔티티 클래스
 * - 생성일자(createdAt) 및 수정일자(updatedAt)를 자동으로 관리하는 기능을 제공
 * - @MappedSuperclass를 사용하여 상속받은 엔티티 클래스들에서 필드를 사용할 수 있도록 함
 * - @EntityListeners(AuditingEntityListener.class)로 JPA Auditing 기능을 활성화하여 자동으로 생성/수정일자를 기록
 */
@Getter
@MappedSuperclass  // 해당 클래스는 엔티티가 아닌, 다른 엔티티가 상속할 수 있는 부모 클래스임을 나타냄
@EntityListeners(AuditingEntityListener.class)  // JPA Auditing 기능을 활성화하여 엔티티의 생성일자 및 수정일자를 자동으로 관리
public abstract class BaseEntity {

    @CreatedDate  // 엔티티 생성 시 자동으로 날짜 기록
    @Column(updatable = false)  // 생성일자는 수정되지 않도록 설정
    private LocalDateTime createdAt;  // 엔티티 생성일자

    @LastModifiedDate  // 엔티티 수정 시 자동으로 날짜 기록
    private LocalDateTime updatedAt;  // 엔티티 수정일자
}
