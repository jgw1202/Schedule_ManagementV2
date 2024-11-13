package com.example.schedule_managementv2.controller;

import com.example.schedule_managementv2.dto.SchedulerRequestDto;
import com.example.schedule_managementv2.dto.SchedulerResponseDto;
import com.example.schedule_managementv2.service.ScheduerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedulers")
public class SchedulerController {

    private final ScheduerService scheduerService;

    @PostMapping
    public ResponseEntity<SchedulerResponseDto> save(@RequestBody SchedulerRequestDto schedulerRequestDto) {
        SchedulerResponseDto schedulerResponseDto = scheduerService.save(
                schedulerRequestDto.getUserName(),
                schedulerRequestDto.getTitle(),
                schedulerRequestDto.getContents());

        return new ResponseEntity<>(schedulerResponseDto, HttpStatus.CREATED);
    }

}
