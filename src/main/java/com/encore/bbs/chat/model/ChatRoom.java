package com.encore.bbs.chat.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoom {

    private String roomId;
    private Long bbsId;


    public static ChatRoom create(Long bbsId) {
        ChatRoom room = new ChatRoom();
        room.roomId = UUID.randomUUID().toString();
        room.bbsId=bbsId;
        return room;
    }
}