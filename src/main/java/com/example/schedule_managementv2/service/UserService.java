package com.example.schedule_managementv2.service;

import com.example.schedule_managementv2.dto.SchedulerResponseDto;
import com.example.schedule_managementv2.dto.UserResponseDto;
import com.example.schedule_managementv2.entity.Scheduler;
import com.example.schedule_managementv2.entity.User;
import com.example.schedule_managementv2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/**
 * User와 관련된 비즈니스 로직을 처리하는 서비스 클래스
 * - 사용자 등록, 조회, 삭제 등의 작업을 처리
 */
@Service  // 이 클래스는 서비스 레이어를 담당하는 빈
@RequiredArgsConstructor  // Lombok을 이용하여 final 필드의 생성자를 자동 생성
public class UserService {

    private final UserRepository userRepository;  // UserRepository 주입

    /**
     * 새로운 사용자를 저장하는 메소드
     * @param name 사용자 이름
     * @param email 사용자 이메일
     * @param password 사용자 비밀번호
     * @return 저장된 사용자에 대한 응답 DTO
     */
    public UserResponseDto save(String name, String email, String password) {

        User user = new User(name,email,password);  // 새로운 사용자 객체 생성

        User savedUser = userRepository.save(user);  // 사용자 저장

        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getUpdatedAt());
    }

    /**
     * 모든 사용자 정보를 조회하는 메소드
     * @return 전체 사용자에 대한 응답 DTO 리스트
     */
    public List<UserResponseDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    /**
     * 특정 ID로 사용자 정보를 조회하는 메소드
     * @param id 조회할 사용자의 ID
     * @return 조회된 사용자에 대한 응답 DTO
     */
    public UserResponseDto findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()) {  // 사용자가 없을 경우 예외 처리
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        User findUser = optionalUser.get();

        return new UserResponseDto(
                findUser.getId(),
                findUser.getName(),
                findUser.getEmail(),
                findUser.getCreatedAt(),
                findUser.getUpdatedAt()
        );
    }

    /**
     * 사용자를 삭제하는 메소드
     * @param id 삭제할 사용자의 ID
     */
    public void delete(Long id) {

        User user =  userRepository.findByIdOrElseThrow(id);  // 사용자 조회

        userRepository.delete(user);  // 사용자 삭제
    }
}
