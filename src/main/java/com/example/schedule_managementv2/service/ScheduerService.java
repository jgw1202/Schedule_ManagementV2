package com.example.schedule_managementv2.service;

import com.example.schedule_managementv2.dto.SchedulerRequestDto;
import com.example.schedule_managementv2.dto.SchedulerResponseDto;
import com.example.schedule_managementv2.entity.Scheduler;
import com.example.schedule_managementv2.entity.User;
import com.example.schedule_managementv2.repository.SchedulerRepository;
import com.example.schedule_managementv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduerService {

    private final SchedulerRepository schedulerRepository;
    private final UserRepository userRepository;

    public SchedulerResponseDto save(Long userId, String title, String contents) {
        // User가 존재하는지 확인
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id = " + userId));

        // User 객체와 함께 Scheduler 생성
        Scheduler scheduler = new Scheduler(user, title, contents);

        // Scheduler 저장
        Scheduler savedScheduler = schedulerRepository.save(scheduler);

        // ResponseDto로 변환하여 반환
        return SchedulerResponseDto.toDto(savedScheduler);
    }

    public List<SchedulerResponseDto> findAll() {
        return schedulerRepository.findAll()
                .stream()
                .map(SchedulerResponseDto::toDto)
                .toList();
    }

    public SchedulerResponseDto findById(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Scheduler not found with id = " + id));
        return SchedulerResponseDto.toDto(scheduler);
    }

    @Transactional
    public SchedulerResponseDto update(Long id, SchedulerRequestDto schedulerRequestDto) {
        Scheduler scheduler = schedulerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Scheduler not found with id = " + id));

        scheduler.update(
                schedulerRequestDto.getTitle(),
                schedulerRequestDto.getContents()
        );

        return SchedulerResponseDto.toDto(scheduler);
    }

    public void delete(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Scheduler not found with id = " + id));

        schedulerRepository.delete(scheduler);
    }
}


