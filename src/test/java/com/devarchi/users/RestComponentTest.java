package com.devarchi.users;

import com.devarchi.users.config.RestConfig;
import com.devarchi.users.service.GetKakaoLoginCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

/**
 * Created by donghoon on 2016. 1. 4..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestConfig.class})
public class RestComponentTest {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GetKakaoLoginCode getKakaoLoginCode;

    @Test
    public void objectNotNull() {
        assertNotNull(restTemplate);
        assertNotNull(getKakaoLoginCode);
    }

    @Test
    public void getKakaoLoginCodeTest() {
        getKakaoLoginCode.getCode();
    }
}
