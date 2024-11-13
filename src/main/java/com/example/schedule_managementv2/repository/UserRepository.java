package com.example.schedule_managementv2.repository;

import com.example.schedule_managementv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

/**
 * User 엔티티에 대한 CRUD 작업을 수행하는 리포지토리 인터페이스.
 * - findByIdOrElseThrow 메소드를 추가하여, 사용자 조회 시 없는 ID일 경우 예외를 던짐
 */
@Repository  // 이 인터페이스가 JPA 리포지토리임을 나타냄
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 주어진 ID로 User를 조회하고, 해당 ID의 User가 존재하지 않으면 예외를 던짐
     * @param id 조회할 User의 ID
     * @return 해당 ID에 해당하는 User
     */
    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id));
    }
}
