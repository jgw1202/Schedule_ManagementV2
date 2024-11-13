package com.example.schedule_managementv2.service;

import com.example.schedule_managementv2.dto.SchedulerResponseDto;
import com.example.schedule_managementv2.entity.Scheduler;
import com.example.schedule_managementv2.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduerService {

    private final SchedulerRepository schedulerRepository;

    public SchedulerResponseDto save(String uesrName, String title, String contents) {

        Scheduler scheduler = new Scheduler(uesrName,title,contents);

        Scheduler savedScheduler = schedulerRepository.save(scheduler);

        return new SchedulerResponseDto(
                savedScheduler.getId(),
                savedScheduler.getUserName(),
                savedScheduler.getTitle(),
                savedScheduler.getContents(),
                savedScheduler.getCreatedAt(),
                savedScheduler.getUpdatedAt());
    }

    public List<SchedulerResponseDto> findAll() {
        return schedulerRepository.findAll()
                .stream()
                .map(SchedulerResponseDto::toDto)
                .toList();
    }
}
