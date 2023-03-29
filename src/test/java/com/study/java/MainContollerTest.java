package com.study.java;


import com.study.java.data.Name;
import com.study.java.entity.user.Center;
import com.study.java.entity.user.UserRepository;
import com.study.java.entity.user.UserRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
// Rest Controller 테스트
//@AutoConfigureMockMvc
// JPA Test
@DataJpaTest
class MainContollerTest {
    Logger logger = LoggerFactory.getLogger(MainContollerTest.class);

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("USER 정보가 저장이 잘 되는 지확인")
    @Transactional
    void userFind() {
        logger.info("입력 처리");
        Center center = new UserRequest(new Name("hong")).toEntity();

        logger.info("저장 처리");
        Center saveUser = userRepository.save(center);
        assertSame(center,saveUser, "성공");
        assertEquals(center.getId(), saveUser.getId());
        assertEquals(center.getName(), saveUser.getName());

        userRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("Member Not Found"));
    }

}