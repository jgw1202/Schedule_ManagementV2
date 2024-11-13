package com.example.schedule_managementv2.repository;

import com.example.schedule_managementv2.entity.Scheduler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, Long> {
    default Scheduler findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}
