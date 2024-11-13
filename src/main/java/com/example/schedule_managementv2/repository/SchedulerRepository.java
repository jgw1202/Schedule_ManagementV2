package com.example.schedule_managementv2.repository;

import com.example.schedule_managementv2.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Scheduler 엔티티에 대한 CRUD 작업을 수행하는 리포지토리 인터페이스.
 * - Spring Data JPA가 자동으로 구현체를 생성하여 제공
 */
@Repository  // 이 인터페이스가 JPA 리포지토리임을 나타냄
public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {
    // JpaRepository는 기본적인 CRUD 메소드들을 자동으로 제공 (save, findAll, findById 등)
}
