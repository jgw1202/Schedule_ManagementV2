package com.example.schedule_managementv2.controller;

import com.example.schedule_managementv2.dto.LoginRequestDto;
import com.example.schedule_managementv2.dto.UserResponseDto;
import com.example.schedule_managementv2.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * LoginController는 사용자 로그인 및 로그아웃 기능을 처리하는 컨트롤러입니다.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LoginController {

    // UserService 인스턴스, 사용자 관련 작업을 처리하기 위해 사용됩니다.
    private final UserService userService;

    /**
     * 사용자 로그인 요청을 처리하는 메서드입니다.
     *
     * @param loginRequestDto 이메일과 비밀번호를 담고 있는 데이터 전송 객체.
     * @param session         로그인 성공 시 사용자 정보를 저장할 HTTP 세션.
     * @return 사용자 정보와 HTTP 상태를 담은 ResponseEntity.
     */
    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpSession session) {

        // 제공된 이메일과 비밀번호를 사용하여 사용자를 인증합니다.
        UserResponseDto user = userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());

        // 로그인 성공 시 세션에 사용자 정보를 저장합니다.
        session.setAttribute("sessionKey값", user);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * 사용자 로그아웃 요청을 처리하는 메서드입니다.
     *
     * @param request HTTP 요청 객체.
     * @return HTTP 상태를 담은 ResponseEntity.
     */
    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletRequest request) {
        // 현재 세션을 가져옵니다. 세션이 없으면 null을 반환합니다.
        HttpSession session = request.getSession(false);
        if (session != null) {
            // 세션이 존재하면 세션을 무효화합니다.
            session.invalidate();
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
