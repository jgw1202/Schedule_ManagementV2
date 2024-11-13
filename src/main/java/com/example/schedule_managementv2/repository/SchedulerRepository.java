package com.example.schedule_managementv2.repository;

import com.example.schedule_managementv2.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {
}
