package com.encore.bbs.comment.service;

import com.encore.bbs.board.mapper.BbsMapper;
import com.encore.bbs.comment.dto.CommentDTO;
import com.encore.bbs.comment.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentMapper commentMapper;
    private final BbsMapper bbsMapper;
    @Override
    public List<CommentDTO> getCommentsByBbsId(int bbsId) {
        return commentMapper.getCommentsByBbsId(bbsId);
    }

    @Override
    @Transactional
    public void addComment(CommentDTO commentDTO) {
        commentMapper.addComment(commentDTO);
    }

    @Override
    @Transactional
    public int updateComment(Long commentId, CommentDTO commentDTO) {
        CommentDTO existingComment = commentMapper.findCommentById(commentId);

        if (existingComment != null) {  // 기존댓글이 존재한다면 , dto와 db update
            commentDTO.setCommentId(commentId);
            commentMapper.updateComment(commentDTO);
        }
        return 0;
    }

    @Override
    @Transactional
    public int deleteComment(Long commentId, String bbsId) {
        commentMapper.deleteComment(commentId);
        return 0;
    }

    @Override
    public int countAllComments() {
        return commentMapper.countAllComments();
    }

    @Override
    public CommentDTO findCommentById(Long commentId) {
        return commentMapper.findCommentById(commentId);
    }
}
