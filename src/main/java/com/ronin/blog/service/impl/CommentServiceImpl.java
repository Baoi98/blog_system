package com.ronin.blog.service.impl;

import com.ronin.blog.entity.Comment;
import com.ronin.blog.mapper.CommentMapper;
import com.ronin.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:32
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> findArticleCommentById(Long articleId) {
        return commentMapper.selectAllCommentByArticleId(articleId);
    }

    @Override
    public int insetComment(Comment comment) {
        int i = commentMapper.insert(comment);
        return i;
    }

    @Override
    public Integer allCommentCount() {
        return commentMapper.allCommentCount();
    }

    @Override
    public int deleteCommentById(Long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

}
