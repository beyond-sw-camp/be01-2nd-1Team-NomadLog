//package com.encore.bbs.board.controller;
//
//import com.encore.bbs.board.dto.BbsDTO;
//import com.encore.bbs.board.service.BbsService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//class BbsControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private BbsService bbsService;
//
//
//    @Test
//    @Transactional
//    void openBbsList() throws Exception {
//
//        BbsDTO bbs1 = new BbsDTO();
//        bbs1.setBbsId(1);
//        bbs1.setTitle("Test title");
//
//        BbsDTO bbs2 = new BbsDTO();
//        bbs1.setBbsId(2);
//        bbs1.setTitle("Test title2222");
//
//        bbsService.insertBbs(bbs1, "가나");
//        bbsService.insertBbs(bbs2, "서울");
//
//        mockMvc.perform(get("bbs"))
//    }
//}