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

/**
 * Scheduler와 관련된 비즈니스 로직을 처리하는 서비스 클래스
 * - 일정 저장, 조회, 수정, 삭제 등의 작업을 처리
 */
@Service  // 이 클래스는 서비스 레이어를 담당하는 빈
@RequiredArgsConstructor  // Lombok을 이용하여 final 필드의 생성자를 자동 생성
public class ScheduerService {

    private final SchedulerRepository schedulerRepository;  // SchedulerRepository 주입
    private final UserRepository userRepository;  // UserRepository 주입

    /**
     * 새로운 일정을 저장하는 메소드
     * @param userId 일정 소유자의 ID
     * @param title 일정의 제목
     * @param contents 일정의 내용
     * @return 저장된 일정에 대한 응답 DTO
     */
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

    /**
     * 모든 일정 정보를 조회하는 메소드
     * @return 전체 일정에 대한 응답 DTO 리스트
     */
    public List<SchedulerResponseDto> findAll() {
        return schedulerRepository.findAll()
                .stream()
                .map(SchedulerResponseDto::toDto)
                .toList();
    }

    /**
     * 특정 ID로 일정을 조회하는 메소드
     * @param id 조회할 일정의 ID
     * @return 조회된 일정에 대한 응답 DTO
     */
    public SchedulerResponseDto findById(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Scheduler not found with id = " + id));
        return SchedulerResponseDto.toDto(scheduler);
    }

    /**
     * 일정을 수정하는 메소드
     * @param id 수정할 일정의 ID
     * @param schedulerRequestDto 수정할 제목과 내용을 포함한 DTO
     * @return 수정된 일정에 대한 응답 DTO
     */
    @Transactional  // 트랜잭션을 처리하도록 지정 (데이터베이스 갱신을 포함)
    public SchedulerResponseDto update(Long id, SchedulerRequestDto schedulerRequestDto) {
        Scheduler scheduler = schedulerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Scheduler not found with id = " + id));

        scheduler.update(
                schedulerRequestDto.getTitle(),
                schedulerRequestDto.getContents()
        );

        return SchedulerResponseDto.toDto(scheduler);
    }

    /**
     * 일정을 삭제하는 메소드
     * @param id 삭제할 일정의 ID
     */
    public void delete(Long id) {
        Scheduler scheduler = schedulerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Scheduler not found with id = " + id));

        schedulerRepository.delete(scheduler);
    }
}
