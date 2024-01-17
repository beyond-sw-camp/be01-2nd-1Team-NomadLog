package com.encore.bbs.chat.controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.encore.bbs.chat.model.ChatRoom;
import com.encore.bbs.chat.service.ChatService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatService chatService;

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model, HttpSession session) {
        Integer loginId = (Integer)session.getAttribute("loginId");
        model.addAttribute("loginId", loginId);
        return "/member/login";
    }
    // 모든 채팅방 목록 반환
    @GetMapping("/rooms")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatService.findAllRoom();
    }
    // 채팅방 생성
    /*  @PostMapping("/room")*/
 /*   @ResponseBody
    public ChatRoom createRoom(@RequestParam String name) {
        return chatService.createRoom(name);
    }*/
    // 채팅방 입장 화면
    @GetMapping("/room/enter/{bbsId}")
    public String roomDetail(Model model, @PathVariable String bbsId) {
        model.addAttribute("bbsId", bbsId);
        return "/chat/roomdetail";
    }
    // 특정 채팅방 조회
    @GetMapping("/room/{bbsId}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String bbsId) {
        return chatService.findById(bbsId);
    }
}