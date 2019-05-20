package com.ronin.blog.mapper;

import com.ronin.blog.entity.Comment;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    /**
     * 根据文章ID查出所有评论
     * @param articleId
     * @return
     */
    List<Comment> selectAllCommentByArticleId(Long articleId);

    /**
     * 所有文章总评论条数
     * @return
     */
    Integer allCommentCount();
}