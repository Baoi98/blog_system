package com.ronin.blog.service;

import com.ronin.blog.entity.Comment;

import java.util.List;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:30
 */
public interface CommentService {

    /**
     * 通过文章ID查找该文章所有评论
     * @param articleId
     * @return
     */
    List<Comment> findArticleCommentById(Long articleId);

    /**
     * 添加评论
     * @param comment
     */
    int insetComment(Comment comment);

    /**
     * 所有文章总评论条数
     * @return
     */
    Integer allCommentCount();

    /**
     * 通过ID删除评论
     * @param id
     * @return
     */
    int deleteCommentById(Long id);
}
