package com.encore.bbs.comment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.encore.bbs.comment.dto.CommentDTO;
import com.encore.bbs.comment.service.CommentService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/save")
    public String saveComment(@ModelAttribute CommentDTO commentDTO) {
        commentService.addComment(commentDTO);

        // 댓글 추가 후, 해당 댓글이 속한 게시글의 상세 페이지로 이동
        return "redirect:/bbs/" + commentDTO.getBbsId();
    }


    // 삭제
    @PostMapping("delete")
    public String deleteComment(@RequestParam("commentId") long commentId, @RequestParam("bbsId") String bbsId) {
        commentService.deleteComment(commentId, bbsId);
        // 댓글 삭제 후, 해당 게시글의 상세 페이지로 이동
        return "redirect:/bbs/" + bbsId;
    }
}