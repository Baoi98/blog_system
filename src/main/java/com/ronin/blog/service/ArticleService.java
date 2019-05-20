package com.ronin.blog.service;

import com.ronin.blog.entity.Article;

import java.util.List;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:30
 */
public interface ArticleService {

    /**
     * 查找所有文章
     * @return
     */
    List<Article> findAllArticle();

    /**
     * 通过ID查找文章
     * @param id
     * @return
     */
    Article findById(Integer id);

    /**
     * 通过ID查找上一篇文章
     * @param id
     * @return
     */
    Article findLastArticleById(Integer id);

    /**
     * 通过ID查找下一篇文章
     * @param id
     * @return
     */
    Article findNextArticleById(Integer id);

    /**
     * 更新文章
     * @param article
     */
    int update(Article article);

    /**
     * 查询文章总数
     * @return
     */
    Integer allArticleCount();

    /**
     * 通过keyWords模糊查询文章
     * @param keyWords
     * @return
     */
    List<Article> findArticleByKeyWord(String keyWords);

    /**
     * 根据ID删除文章
     * @param articleId
     * @return
     */
    int deleteById(Integer articleId);

    /**
     * 添加文章
     * @param article
     * @return
     */
    int insertArticle(Article article);

}
