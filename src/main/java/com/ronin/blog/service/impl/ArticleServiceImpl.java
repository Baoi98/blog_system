package com.ronin.blog.service.impl;

import com.ronin.blog.entity.Article;
import com.ronin.blog.mapper.ArticleMapper;
import com.ronin.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:32
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> findAllArticle() {
        List<Article> articleList = articleMapper.findAllArticle();
        return articleList;
    }

    @Override
    public Article findById(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public Article findLastArticleById(Integer id) {
        Article lastArticle = articleMapper.findLastOrNextArticleById(id - 1);
        if(StringUtils.isEmpty(lastArticle)){
            return null;
        }
        return lastArticle;
    }

    @Override
    public Article findNextArticleById(Integer id) {
        Article nextArticle = articleMapper.findLastOrNextArticleById(id + 1);
        if(StringUtils.isEmpty(nextArticle)){
            return null;
        }
        return nextArticle;
    }

    @Override
    public int update(Article article) {
        int i = articleMapper.updateByPrimaryKeySelective(article);
        return i;
    }

    @Override
    public Integer allArticleCount() {
        return articleMapper.allArticleCount();
    }

    @Override
    public List<Article> findArticleByKeyWord(String keyWords) {
        List<Article> articleList = articleMapper.findArticleByKeyWord(keyWords);
        return articleList;
    }

    @Override
    public int deleteById(Integer articleId) {
        return articleMapper.deleteByPrimaryKey(articleId);
    }

    @Override
    public int insertArticle(Article article) {
        return articleMapper.insert(article);
    }

}
