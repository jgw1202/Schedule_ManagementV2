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
    public ResponseEntity<SchedulerResponseDto> saveScheduler(@RequestBody SchedulerRequestDto schedulerRequestDto) {
        System.out.println("Received SchedulerRequestDto: " + schedulerRequestDto.getUserId() +
                ", Title: " + schedulerRequestDto.getTitle() +
                ", Contents: " + schedulerRequestDto.getContents());

        SchedulerResponseDto schedulerResponseDto = scheduerService.save(
                schedulerRequestDto.getUserId(),
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

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScheduler(@PathVariable Long id) {

        scheduerService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
