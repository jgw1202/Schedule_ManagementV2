package com.example.schedule_managementv2.controller;

import com.example.schedule_managementv2.dto.*;
import com.example.schedule_managementv2.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  // 이 클래스가 REST API Controller임을 선언
@RequiredArgsConstructor  // 필요한 생성자를 자동으로 생성해주는 Lombok 어노테이션
@RequestMapping("/api/users")  // 이 컨트롤러의 모든 메소드 URL에 /api/users 경로를 앞에 붙임
public class UserController {

    private final UserService userService;  // UserService 의존성 주입

    /**
     * 유저 등록 API
     * - 요청 본문에 포함된 UserSaveRequestDto를 바탕으로 유저를 등록한다.
     * - 이름, 이메일, 비밀번호가 포함된 요청을 처리한다.
     *
     * @param userSaveRequestDto 유저 정보가 담긴 요청 DTO
     * @return 등록된 유저 정보가 담긴 ResponseDto
     */
    @PostMapping
    public ResponseEntity<UserResponseDto> saveUser(@Valid @RequestBody UserSaveRequestDto userSaveRequestDto) {
        // 서비스 레이어를 통해 유저를 저장하고, 반환된 DTO를 클라이언트에 응답
        UserResponseDto userResponseDto = userService.save(
                userSaveRequestDto.getName(),
                userSaveRequestDto.getEmail(),
                userSaveRequestDto.getPassword());

        // 유저를 정상적으로 등록한 후 201 CREATED 상태 코드와 함께 ResponseEntity 반환
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }

    /**
     * 전체 유저 조회 API
     * - 모든 유저를 조회하여 목록을 반환한다.
     *
     * @return 유저 목록이 담긴 ResponseEntity
     */
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {
        // 서비스 레이어를 통해 모든 유저를 조회하고, ResponseEntity로 반환
        List<UserResponseDto> userResponseDtoList = userService.findAll();

        // 전체 유저를 조회하여 200 OK 상태 코드와 함께 반환
        return new ResponseEntity<>(userResponseDtoList, HttpStatus.OK);
    }

    /**
     * 단건 유저 조회 API
     * - ID에 해당하는 유저를 조회하여 반환한다.
     *
     * @param id 조회할 유저의 ID
     * @return 유저 정보가 담긴 ResponseEntity
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findByIdUser(@PathVariable Long id) {
        // 서비스 레이어를 통해 단건 유저를 조회하고, ResponseEntity로 반환
        UserResponseDto userResponseDto = userService.findById(id);

        // 해당 유저가 존재하면 200 OK 상태 코드와 함께 반환
        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    /**
     * 유저 삭제 API
     * - 유저 ID를 받아 해당 유저를 삭제한다.
     *
     * @param id 삭제할 유저의 ID
     * @return 삭제 완료 상태를 나타내는 ResponseEntity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        // 서비스 레이어를 통해 유저를 삭제
        userService.delete(id);

        // 삭제 완료 후 200 OK 상태 코드와 함께 반환
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
