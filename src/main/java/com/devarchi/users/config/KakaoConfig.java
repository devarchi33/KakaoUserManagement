package com.devarchi.users.config;

import com.devarchi.users.KakaoPropertyProvider;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by donghoon on 2016. 1. 4..
 */
@Configuration
@PropertySource("classpath:kakao/kakao.properties")
@ComponentScan(basePackages = "com.devarchi.users")
public class KakaoConfig {

    //@Value 애노테이션을 사용하기 위한 Bean 등록.
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${rest.key}")
    private String kakaoRestKey;

    @Value("${url.kakao.login.code}")
    private String kakaoLoginCodeUrl;

    @Value("${redirect.uri}")
    private String redirectUri;

    @Bean
    public KakaoPropertyProvider getKakaoPropertyProvider() {
        KakaoPropertyProvider kp = new KakaoPropertyProvider();
        kp.setKakaoLoginCodeUrl(kakaoLoginCodeUrl);
        kp.setKakaoRestKey(kakaoRestKey);
        kp.setRedirectUri(redirectUri);
        return kp;
    }
}
