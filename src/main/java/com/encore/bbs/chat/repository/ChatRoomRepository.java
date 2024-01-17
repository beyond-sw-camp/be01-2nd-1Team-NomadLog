package com.encore.bbs.chat.repository;

import com.encore.bbs.chat.model.ChatRoom;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public class ChatRoomRepository {



    private Map<Long, ChatRoom> chatRoomMap;

    @PostConstruct
    private void init() {
        chatRoomMap = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom() {
        // 채팅방 생성순서 최근 순으로 반환
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }

    public ChatRoom findRoomById(Long id) {
        return chatRoomMap.get(id);
    }

    public ChatRoom createChatRoom(Long bbsId) {
        ChatRoom chatRoom = ChatRoom.create(bbsId);
        chatRoomMap.put((chatRoom.getBbsId()), chatRoom);
        return chatRoom;
    }
}