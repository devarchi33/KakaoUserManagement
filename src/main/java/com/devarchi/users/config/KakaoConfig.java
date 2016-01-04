package com.devarchi.users.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by donghoon on 2016. 1. 4..
 */
@Configuration
@PropertySource("classpath:kakao/kakao.properties")
@Getter
public class KakaoConfig {

    @Value("${rest.key}")
    private String kakaoRestKey;

    //@Value 애노테이션을 사용하기 위한 Bean 등록.
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
