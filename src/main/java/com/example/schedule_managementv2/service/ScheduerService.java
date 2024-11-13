package com.example.schedule_managementv2.service;

import com.example.schedule_managementv2.dto.SchedulerRequestDto;
import com.example.schedule_managementv2.dto.SchedulerResponseDto;
import com.example.schedule_managementv2.entity.Scheduler;
import com.example.schedule_managementv2.repository.SchedulerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public SchedulerResponseDto findById(Long id) {
        Optional<Scheduler> optionalScheduler = schedulerRepository.findById(id);

        if(optionalScheduler.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        Scheduler findScheduler = optionalScheduler.get();

        return new SchedulerResponseDto(
                findScheduler.getId(),
                findScheduler.getUserName(),
                findScheduler.getTitle(),
                findScheduler.getContents(),
                findScheduler.getCreatedAt(),
                findScheduler.getUpdatedAt());
    }

    @Transactional
    public SchedulerResponseDto update(Long id, SchedulerRequestDto schedulerRequestDto) {

        Scheduler scheduler = schedulerRepository.findByIdOrElseThrow(id);

        scheduler.update(
                schedulerRequestDto.getUserName(),
                schedulerRequestDto.getTitle(),
                schedulerRequestDto.getContents()
        );

        return new SchedulerResponseDto(scheduler.getId(),
                scheduler.getUserName(),
                scheduler.getTitle(),
                scheduler.getContents(),
                scheduler.getCreatedAt(),
                scheduler.getUpdatedAt());
    }
}
