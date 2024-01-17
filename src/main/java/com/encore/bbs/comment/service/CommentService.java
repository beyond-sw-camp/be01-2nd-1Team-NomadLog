package com.encore.bbs.comment.service;

import com.encore.bbs.comment.dto.CommentDTO;

import java.util.List;

/**
 * 댓글 관련 비즈니스 로직을 처리하는 서비스 인터페이스입니다.
 */
public interface CommentService {

    /**
     * 게시물 번호에 해당하는 댓글 목록을 가져오는 메서드
     * @param bbsId 게시물 번호
     * @return 댓글 목록
     */
    List<CommentDTO> getCommentsByBbsId(int bbsId);

    /**
     * 댓글 식별자에 댓글 id 가져오는 메서드
     * @param commentId 댓글 식별자
     * @return 댓글 정보
     */
    CommentDTO findCommentById(Long commentId);

    /**
     * 새로운 댓글을 추가하는 메서드
     * @param commentDTO 추가할 댓글 정보
     */
    void addComment(CommentDTO commentDTO);

    /**
     * 댓글을 수정하는 메서드
     *
     * @param commentId  댓글 식별자
     * @param commentDTO 수정할 댓글 정보
     * @return
     */
    int updateComment(Long commentId, CommentDTO commentDTO);

    /**
     * 댓글을 삭제하는 메서드
     *
     * @param commentId 삭제할 댓글의 식별자
     * @param bbsId
     * @return
     */
    int deleteComment(Long commentId, String bbsId);

    /**
     * 댓글 전체 개수를 가져오는 메서드
     * @return 댓글 전체 개수
     */
    int countAllComments();


}
