package com.devarchi.users.service;

import com.devarchi.users.config.KakaoConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by donghoon on 2016. 1. 4..
 */
@Service
public class GetKakaoLoginCode {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private KakaoConfig kakaoConfig;

    public void getCode() {
        String kakaoRestKey = kakaoConfig.getKakaoRestKey();

    }
}
