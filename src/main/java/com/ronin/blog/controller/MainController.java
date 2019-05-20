package com.ronin.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ronin.blog.entity.Article;
import com.ronin.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:33
 */
@Controller
public class MainController {

    @Autowired
    private ArticleService articleService;

    /**
     * 主页方法
     * @param pageNum 第几页
     * @param pageSize 每页条数
     * @param model
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index(@RequestParam(value = "pageNum",required = true,defaultValue = "1")Integer pageNum,
                        @RequestParam(value = "pageSize",required = true,defaultValue = "5")Integer pageSize,
                        Model model){
        //pageHelper设置页数条数
        PageHelper.startPage(pageNum,pageSize);
        //查询文章集合
        List<Article> articleList = articleService.findAllArticle();
        //设置pageHelper集合
        PageInfo<Article> pageInfo = new PageInfo<>(articleList);
        //添加属性到model
        model.addAttribute("articleList",articleList);
        model.addAttribute("pageInfo",pageInfo);

        return "index";
    }

    /**
     * 跳转到关于我们
     * @return
     */
    @RequestMapping(value = "about",method = RequestMethod.GET)
    public String about(){
        return "about";
    }



}
