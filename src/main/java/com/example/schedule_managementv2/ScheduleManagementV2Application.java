package com.example.schedule_managementv2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Spring Boot 애플리케이션의 엔트리 포인트 클래스
 * - 애플리케이션 실행을 위한 main 메소드를 포함
 * - Spring Boot의 자동 설정 기능과 JPA Auditing을 활성화
 */
@EnableJpaAuditing  // JPA Auditing 기능을 활성화하여, 엔티티의 생성 및 수정 시간 자동 추적을 가능하게 함
@SpringBootApplication  // Spring Boot 애플리케이션을 설정하고 실행하는 어노테이션
public class ScheduleManagementV2Application {

    /**
     * 애플리케이션 실행을 위한 main 메소드
     * @param args 커맨드라인 인자
     */
    public static void main(String[] args) {
        // Spring Boot 애플리케이션 실행
        SpringApplication.run(ScheduleManagementV2Application.class, args);
    }
}
