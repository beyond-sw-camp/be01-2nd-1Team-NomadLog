package com.encore.bbs.comment.mapper;

import com.encore.bbs.comment.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * MyBatis 매퍼 인터페이스: Comment 엔터티와 관련된 데이터 액세스 작업을 정의합니다.
 */

@Mapper
public interface CommentMapper {

    /**
     * 게시물 번호에 해당하는 댓글 목록을 가져오는 메서드(조회)
     * @param bbsId 게시물 번호
     * @return 댓글 목록
     */
    List<CommentDTO> getCommentsByBbsId(int bbsId);

    /**
     * 새로운 댓글을 추가하는 메서드
     * @param commentDTO 추가할 댓글 정보
     */
    void addComment(CommentDTO commentDTO);


    /**
     * 댓글 식별자에 해당하는 댓글을 가져오는 메서드
     * @param commentId 댓글 식별자
     * @return 댓글 정보
     */
    CommentDTO findCommentById(Long commentId);

    /**
     * 댓글을 수정하는 메서드
     * @param commentDTO 수정할 댓글 정보
     */
    void updateComment(CommentDTO commentDTO);

    /**
     * 댓글을 삭제하는 메서드
     * @param commentId 삭제할 댓글 식별자
     */
    void deleteComment(Long commentId);

    /**
     * 댓글 전체 개수를 가져오는 메서드
     * @return 댓글 전체 개수
     */
    int countAllComments();

}
