package com.devarchi.users;

import lombok.Data;

/**
 * Created by donghoon on 2016. 1. 5..
 */
@Data
public class KakaoPropertyProvider {

    private String kakaoRestKey;
    private String kakaoLoginCodeUrl;
    private String redirectUri;
}
