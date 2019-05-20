package com.ronin.blog.controller;

import com.ronin.blog.entity.Article;
import com.ronin.blog.entity.Catalog;
import com.ronin.blog.entity.Comment;
import com.ronin.blog.service.ArticleService;
import com.ronin.blog.service.CatalogService;
import com.ronin.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文章控制器
 * @Author: 98
 * @Date: 2019-5-17 23:32
 */
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private CatalogService catalogService;

    /**
     * 文章详情
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "article",method = RequestMethod.GET)
    public String detail(HttpServletRequest request, Model model){
        //获取传入的id值
        Integer id = Integer.parseInt(request.getParameter("id"));

        //通过id值查找文章和文章的上一篇与下一篇
        Article article = articleService.findById(id);

        Article lastArticle = articleService.findLastArticleById(id);
        Article nextArticle = articleService.findNextArticleById(id);

        //查询文章的所有评论  默认10条
        List<Comment> commentList = commentService.findArticleCommentById(id.longValue());

        //修改文章的点击数
        article.setClick(article.getClick()+1);
        articleService.update(article);

        model.addAttribute("article",article);
        model.addAttribute("lastArticle",lastArticle);
        model.addAttribute("nextArticle",nextArticle);
        model.addAttribute("commentList",commentList);


        return "detail";
    }

    /**
     * 管理员主页搜索文章
     * @param model
     * @param keyWords
     * @return
     */
    @RequestMapping(value = "/admin/article/search",method = RequestMethod.GET)
    public String articleSearch(Model model,String keyWords){
        //通过关键字查找符合的文章
        List<Article> articleList = articleService.findArticleByKeyWord(keyWords);
        //保存信息
        model.addAttribute("articleList",articleList);

        return "admin/article_list";
    }

    /**
     * 管理员查看文章详情
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/article/detail",method = RequestMethod.GET)
    public String articleDetail(String id,Model model){
        Integer articleId = Integer.parseInt(id);
        //查找文章详情
        Article article = articleService.findById(articleId);
        //存放信息
        model.addAttribute("article",article);

        return "admin/article_detail";
    }

    /**
     * 管理员查看评论
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/article/comment",method = RequestMethod.GET)
    public String articleComment(String id,Model model){
        Long articleId = Long.parseLong(id);
        //查找文章所有评论
        List<Comment> comments = commentService.findArticleCommentById(articleId);
        //存放信息
        model.addAttribute("comments",comments);

        return "admin/comment_list";
    }

    /**
     * 管理员编辑
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/article/edit",method = RequestMethod.GET)
    public String articleEdit(String id,Model model){
        Integer articleId = Integer.parseInt(id);
        //查找文章详情
        Article article = articleService.findById(articleId);
        //查找栏目信息
        List<Catalog> catalogList = catalogService.findAllCatalog();
        //存放信息
        model.addAttribute("article",article);
        model.addAttribute("catalogList",catalogList);

        return "admin/article_edit";
    }

    /**
     * 编辑文章提交
     * @param article
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/article/edit/do",method = RequestMethod.POST)
    public String doArticleEdit(Article article,Model model){
        //修改文章
        int i = articleService.update(article);
        //判断是否更新成功
        if(i > 0){
            model.addAttribute("succ","文章修改成功");
        }
        else{
            model.addAttribute("error","文章修改失败");
        }
        //查找栏目信息
        List<Catalog> catalogList = catalogService.findAllCatalog();
        model.addAttribute("catalogList",catalogList);

        return "admin/article_edit";
    }

    /**
     * 管理员查看所有文章
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/article/list",method = RequestMethod.GET)
    public String articleList(Model model){
        //查询所有文章
        List<Article> allArticle = articleService.findAllArticle();
        //存放信息
        model.addAttribute("articleList",allArticle);

        return "admin/article_list";
    }

    /**
     * 跳转到添加文章页面
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/article/add",method = RequestMethod.GET)
    public String articleAdd(Model model){
        //查找栏目信息
        List<Catalog> catalogList = catalogService.findAllCatalog();
        model.addAttribute("catalogList",catalogList);

        return "admin/article_add";
    }

    /**
     * 删除文章API
     * @param id
     * @return stateCode = 1 删除成功
     */
    @RequestMapping(value = "/api/article/del",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> articleDel(String id){
        //创建数据返回对象
        Map<String,String> map = new HashMap<>();
        //转换类型
        Integer articleId = Integer.parseInt(id);
        int i = articleService.deleteById(articleId);
        //判断结果
        if(i > 0){
            map.put("stateCode","1");
        }
        else{
            map.put("stateCode","0");
        }

        return map;
    }

    /**
     * 添加文章
     * @param redirectAttributes
     * @param article
     * @return
     */
    @RequestMapping(value = "/admin/article/add/do",method = RequestMethod.POST)
    public String doArticleAdd(RedirectAttributes redirectAttributes, Article article){
        article.setTime(new Date());
        article.setClick(0);
        //插入数据库
        int i = articleService.insertArticle(article);
        //判断结果
        if(i > 0){
            redirectAttributes.addFlashAttribute("succ","添加文章成功");
        }
        else{
            redirectAttributes.addFlashAttribute("error","添加文章失败");
        }

        return "redirect:/admin/article/list";
    }
}
