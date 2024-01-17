package com.encore.bbs.member.dto;

import lombok.Data;

@Data
public class CommentDTO {
	String content;
	int likenum;
	String memberId;
}
