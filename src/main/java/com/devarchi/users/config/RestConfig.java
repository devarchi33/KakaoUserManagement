package com.devarchi.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by donghoon on 2016. 1. 4..
 */
@Configuration
@ComponentScan(basePackages = "com.devarchi.users.service")
public class RestConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
