package com.encore.bbs.chat.service;



import com.encore.bbs.chat.model.ChatRoom;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChatService {

    private Map<Long, ChatRoom> chatRooms;

    @PostConstruct
    //의존관게 주입완료되면 실행되는 코드
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    //채팅방 불러오기
    public List<ChatRoom> findAllRoom() {
        //채팅방 최근 생성 순으로 반환
        List<ChatRoom> result = new ArrayList<>(chatRooms.values());
        Collections.reverse(result);

        return result;
    }

    //채팅방 하나 불러오기
    public ChatRoom findById(String bbsId) {
        return chatRooms.get(bbsId);
    }

    //채팅방 생성
    public ChatRoom createRoom(Long bbsId) {
        ChatRoom chatRoom = ChatRoom.create(bbsId);
        chatRooms.put(chatRoom.getBbsId(), chatRoom);
        return chatRoom;
    }

}