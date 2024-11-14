package com.example.schedule_managementv2.config;

import com.example.schedule_managementv2.filter.LoginFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * WebConfig 클래스는 애플리케이션의 웹 설정을 구성하는 클래스입니다.
 */
@Configuration
public class WebConfig {

    /**
     * LoginFilter를 등록하는 메서드입니다.
     *
     * @return FilterRegistrationBean 객체로서 LoginFilter를 등록하고 설정합니다.
     */
    @Bean
    public FilterRegistrationBean loginFilter() {
        // FilterRegistrationBean 객체 생성
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        // LoginFilter를 Filter로 등록
        filterRegistrationBean.setFilter(new LoginFilter());

        // Filter의 순서를 1로 설정
        filterRegistrationBean.setOrder(1);

        // 모든 URL 패턴에 대해 Filter 적용
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
