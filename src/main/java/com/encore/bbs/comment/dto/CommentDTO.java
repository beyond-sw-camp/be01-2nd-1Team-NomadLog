package com.encore.bbs.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
   private Long commentId; // 댓글 식별자
   private int bbsId; // 게시물 번호
   private String content; // 댓글 내용
   private String writer; // 작성자
   private LocalDateTime regDate; // 작성일
   private LocalDateTime modifyDate; // 수정일

}