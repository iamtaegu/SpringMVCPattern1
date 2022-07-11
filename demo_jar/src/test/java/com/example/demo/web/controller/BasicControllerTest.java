package com.example.demo.web.controller;

import com.example.demo.service.MemberService;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// junit 실행할 때 spring하고 같이 실행
@RunWith(SpringRunner.class)
// springboot를 띄운 상태에서
//@SpringBootTest
// 테스트 끝나면 db에 commit이 아닌 rollback 하겠다
//@Transactional
@WebMvcTest(controllers = BasicController.class)
class BasicControllerTest {

    @Autowired
    private MockMvc mvc;

    @BeforeEach
    void beforeEach() {
        System.out.println("beforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("afterEach");
    }

    @Test
    //@Rollback(false)
    public void baisc() throws Exception {
        //given
        String msg = "basic is good";

        //when
        mvc.perform(get("/basic"))
                .andExpect(status().isOk())
                .andExpect(content().string(msg));
        //then

     }

}