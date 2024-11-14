package com.example.schedule_managementv2.config;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component  // 이 클래스를 Spring의 Bean으로 등록하여 의존성 주입을 가능하게 함
public class PasswordEncoder {

    /**
     * 주어진 원시 비밀번호를 BCrypt 알고리즘을 이용해 암호화합니다.
     *
     * @param rawPassword 암호화할 원시 비밀번호
     * @return 암호화된 비밀번호
     */
    public String encode(String rawPassword) {
        // BCrypt.MIN_COST: 최소 비용을 설정하여 상대적으로 빠르게 암호화 (속도와 보안 간의 균형)
        // hashToString: 주어진 원시 비밀번호를 BCrypt로 암호화하고 문자열로 반환
        return BCrypt.withDefaults().hashToString(BCrypt.MIN_COST, rawPassword.toCharArray());
    }

    /**
     * 입력된 원시 비밀번호와 저장된 암호화된 비밀번호를 비교하여 일치하는지 확인합니다.
     *
     * @param rawPassword 원시 비밀번호
     * @param encodedPassword 암호화된 비밀번호
     * @return 비밀번호가 일치하면 true, 아니면 false
     */
    public boolean matches(String rawPassword, String encodedPassword) {
        // BCrypt.verifyer().verify: 주어진 원시 비밀번호와 암호화된 비밀번호를 비교
        // result.verified: 비교 결과가 일치하면 true, 아니면 false 반환
        BCrypt.Result result = BCrypt.verifyer().verify(rawPassword.toCharArray(), encodedPassword);
        return result.verified;  // 비교 결과 반환
    }
}
