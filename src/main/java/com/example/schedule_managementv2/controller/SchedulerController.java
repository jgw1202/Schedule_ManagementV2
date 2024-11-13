package com.example.schedule_managementv2.controller;

import com.example.schedule_managementv2.dto.SchedulerRequestDto;
import com.example.schedule_managementv2.dto.SchedulerResponseDto;
import com.example.schedule_managementv2.service.ScheduerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // 이 클래스가 REST API Controller임을 선언
@RequiredArgsConstructor  // 필요한 생성자를 자동으로 생성해주는 Lombok 어노테이션
@RequestMapping("/api/schedulers")  // 이 컨트롤러의 모든 메소드 URL에 /api/schedulers 경로를 앞에 붙임
public class SchedulerController {

    private final ScheduerService scheduerService;  // ScheduerService 의존성 주입

    /**
     * 일정 등록 API
     * - 요청 본문에 포함된 SchedulerRequestDto를 바탕으로 일정을 등록한다.
     * - 사용자 ID, 제목, 내용이 포함된 요청을 처리한다.
     *
     * @param schedulerRequestDto 일정 정보가 담긴 요청 DTO
     * @return 일정 정보가 담긴 ResponseDto
     */
    @PostMapping
    public ResponseEntity<SchedulerResponseDto> saveScheduler(@RequestBody SchedulerRequestDto schedulerRequestDto) {
        // 서비스 레이어를 통해 일정을 저장하고, 반환된 DTO를 클라이언트에 응답
        SchedulerResponseDto schedulerResponseDto = scheduerService.save(
                schedulerRequestDto.getUserId(),
                schedulerRequestDto.getTitle(),
                schedulerRequestDto.getContents());

        // 일정을 정상적으로 등록한 후 201 CREATED 상태 코드와 함께 ResponseEntity 반환
        return new ResponseEntity<>(schedulerResponseDto, HttpStatus.CREATED);
    }

    /**
     * 전체 일정 조회 API
     * - 모든 일정을 조회하여 목록을 반환한다.
     *
     * @return 일정 목록이 담긴 ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<SchedulerResponseDto>> findAllScheduler() {
        // 서비스 레이어를 통해 모든 일정을 조회하고, ResponseEntity로 반환
        List<SchedulerResponseDto> schedulerResponseDtoList = scheduerService.findAll();

        // 전체 일정을 조회하여 200 OK 상태 코드와 함께 반환
        return new ResponseEntity<>(schedulerResponseDtoList, HttpStatus.OK);
    }

    /**
     * 단건 일정 조회 API
     * - ID에 해당하는 일정을 조회하여 반환한다.
     *
     * @param id 조회할 일정의 ID
     * @return 일정 정보가 담긴 ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<SchedulerResponseDto> findByIdScheduler(@PathVariable Long id) {
        // 서비스 레이어를 통해 단건 일정을 조회하고, ResponseEntity로 반환
        SchedulerResponseDto schedulerResponseDto = scheduerService.findById(id);

        // 해당 일정이 존재하면 200 OK 상태 코드와 함께 반환
        return new ResponseEntity<>(schedulerResponseDto, HttpStatus.OK);
    }

    /**
     * 일정 수정 API
     * - 일정 ID와 수정할 정보를 받아 해당 일정을 업데이트 한다.
     *
     * @param id                      수정할 일정의 ID
     * @param schedulerRequestDto      수정할 내용이 담긴 요청 DTO
     * @return 수정된 일정 정보가 담긴 ResponseEntity
     */
    @PutMapping("/{id}")
    public ResponseEntity<SchedulerResponseDto> updateScheduler(@PathVariable Long id, @RequestBody SchedulerRequestDto schedulerRequestDto) {
        // 서비스 레이어를 통해 일정을 업데이트하고, 수정된 DTO를 클라이언트에 응답
        SchedulerResponseDto schedulerResponseDto = scheduerService.update(id, schedulerRequestDto);

        // 수정된 일정 정보를 200 OK 상태 코드와 함께 반환
        return new ResponseEntity<>(schedulerResponseDto, HttpStatus.OK);
    }

    /**
     * 일정 삭제 API
     * - 일정 ID를 받아 해당 일정을 삭제한다.
     *
     * @param id 삭제할 일정의 ID
     * @return 삭제 완료 상태를 나타내는 ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduler(@PathVariable Long id) {
        // 서비스 레이어를 통해 일정을 삭제
        scheduerService.delete(id);

        // 삭제 완료 후 200 OK 상태 코드와 함께 반환
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
