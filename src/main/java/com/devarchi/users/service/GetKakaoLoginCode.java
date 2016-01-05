package com.devarchi.users.service;

import com.devarchi.users.config.KakaoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by donghoon on 2016. 1. 4..
 */
@Service
public class GetKakaoLoginCode {

    @Autowired
    private RestTemplate restTemplate;

    public void getCode() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KakaoConfig.class);
        ConfigurableEnvironment env = ctx.getEnvironment();

        String kakaoLoginCodeUrl = env.getProperty("url.kakao.login.code");
        String kakaoRestKey = env.getProperty("rest.key");
        String redirectUri = env.getProperty("redirect.uri");

        System.out.println();
        System.out.println("Url: " + kakaoLoginCodeUrl);
        System.out.println("Key: " + kakaoRestKey);
        System.out.println("reUri: " + redirectUri);

        HttpHeaders headers = new HttpHeaders();

        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("client_id", kakaoRestKey);
        paramMap.add("redirect_uri", redirectUri);
        paramMap.add("response_type", "code");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(paramMap, headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(kakaoLoginCodeUrl, HttpMethod.GET, requestEntity, String.class);

        HttpStatus status = responseEntity.getStatusCode();
        HttpHeaders responseHeaders = responseEntity.getHeaders();

        System.out.println("status: " + status);

        for (HttpHeaders.Entry header : responseHeaders.entrySet()) {
            System.out.println("Header: " + header);
        }
    }
}
