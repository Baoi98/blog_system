package com.ronin.blog.mapper;

import com.ronin.blog.entity.Article;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);


    /**
     * 倒序查找所有文章
     * @return
     */
    List<Article> findAllArticle();

    /**
     * 通过ID查找上一篇或下一篇文章
     * @param id
     * @return
     */
    Article findLastOrNextArticleById(Integer id);

    Integer allArticleCount();

    /**
     * 通过keyWords模糊查询文章
     * @param keyWords
     * @return
     */
    List<Article> findArticleByKeyWord(String keyWords);

}