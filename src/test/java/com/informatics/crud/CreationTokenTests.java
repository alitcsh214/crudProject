package com.informatics.crud;

import com.informatics.crud.common.CheckToken;
import com.informatics.crud.common.JwtProvider;
import com.informatics.crud.service.CommonService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ali Alavi
 */

@SpringBootTest
public class CreationTokenTests {

    @Autowired
    private CommonService commonService;

    @Autowired
    private JwtProvider jwtProvider;

    private static final Logger LOGGER = LoggerFactory.getLogger(CreationTokenTests.class);

    @Test
    public void testToken(){
        String token= commonService.getToken("ali alavi");
        LOGGER.info("token JWT = "+token);
        String userName=jwtProvider.extractUserName(token);
        try {
            assertEquals("ali alavi",userName);
        }catch (Exception e){
            fail("error");
        }


    }


}
