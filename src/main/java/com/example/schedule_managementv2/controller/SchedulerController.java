package com.example.schedule_managementv2.controller;

import com.example.schedule_managementv2.dto.SchedulerRequestDto;
import com.example.schedule_managementv2.dto.SchedulerResponseDto;
import com.example.schedule_managementv2.service.ScheduerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedulers")
public class SchedulerController {

    private final ScheduerService scheduerService;

    // 일정 등록
    @PostMapping
    public ResponseEntity<SchedulerResponseDto> save(@RequestBody SchedulerRequestDto schedulerRequestDto) {

        SchedulerResponseDto schedulerResponseDto = scheduerService.save(
                schedulerRequestDto.getUserName(),
                schedulerRequestDto.getTitle(),
                schedulerRequestDto.getContents());

        return new ResponseEntity<>(schedulerResponseDto, HttpStatus.CREATED);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<SchedulerResponseDto>> findAllScheduler() {

        List<SchedulerResponseDto> schedulerResponseDtoList = scheduerService.findAll();

        return new ResponseEntity<>(schedulerResponseDtoList, HttpStatus.OK);
    }

    // 일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<SchedulerResponseDto> findByIdScheduler(@PathVariable Long id) {

        SchedulerResponseDto schedulerResponseDto = scheduerService.findById(id);

        return new ResponseEntity<>(schedulerResponseDto, HttpStatus.OK);
    }

    // 일정 수정
    @PutMapping("/{id}")
    public ResponseEntity<SchedulerResponseDto> updateScheduler(@PathVariable Long id, @RequestBody SchedulerRequestDto schedulerRequestDto) {

        SchedulerResponseDto schedulerResponseDto = scheduerService.update(id, schedulerRequestDto);

        return new ResponseEntity<>(schedulerResponseDto, HttpStatus.OK);
    }

}
