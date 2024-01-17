package com.encore.bbs.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
public class HashTag {
    private Long hashtagId;
    private String content;
    private Long bbsId;

    public HashTag(String content, Long bbsId) {
        this.content = content;
        this.bbsId = bbsId;
    }
}
