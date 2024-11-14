package com.example.schedule_managementv2.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import java.io.IOException;

/**
 * LoginFilter는 특정 URL에 대한 요청을 필터링하여
 * 사용자가 로그인했는지 여부를 확인하는 필터입니다.
 */
@Slf4j
public class LoginFilter implements Filter {

    // 인증을 하지 않아도 될 URL Path 배열
    private static final String[] WHITE_LIST = {"/", "/api/users", "/api/login", "/api/logout"};

    /**
     * 요청이 필터를 통과할 때 호출되는 메서드입니다.
     *
     * @param request  클라이언트 요청 객체
     * @param response 서버 응답 객체
     * @param chain    다음 필터 또는 서블릿으로 요청을 전달하는 객체
     * @throws IOException      입출력 예외
     * @throws ServletException 서블릿 예외
     */
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {

        // 다양한 기능을 사용하기 위해 다운 캐스팅
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        // 다양한 기능을 사용하기 위해 다운 캐스팅
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("로그인 필터 로직 실행");

        // 로그인을 체크해야 하는 URL인지 검사
        if (!isWhiteList(requestURI)) {
            // 세션을 가져옵니다. 세션이 없으면 null을 반환합니다.
            HttpSession session = httpRequest.getSession(false);
            if (session == null || session.getAttribute("sessionKey값") == null) {
                // 로그인하지 않은 사용자일 경우 예외를 발생시킵니다.
                throw new RuntimeException("로그인 해주세요.");
            }
        }

        // 다음 필터 또는 서블릿으로 요청을 전달합니다.
        chain.doFilter(request, response);
    }

    /**
     * 요청 URI가 인증이 필요 없는 URL인지 확인하는 메서드입니다.
     *
     * @param requestURI 요청 URI
     * @return 인증이 필요 없는 URL이면 true, 그렇지 않으면 false
     */
    private boolean isWhiteList(String requestURI) {
        boolean isWhiteList = PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
        log.info("Request URI: {} isWhiteList: {}", requestURI, isWhiteList);
        return isWhiteList;
    }
}
