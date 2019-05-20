package com.ronin.blog.controller;

import com.ronin.blog.entity.Comment;
import com.ronin.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 评论控制器
 * @Author: 98
 * @Date: 2019-5-17 23:33
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    /**
     * 添加评论
     * @param request
     * @return
     */
    @RequestMapping(value = "/api/comment/add",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> comment(HttpServletRequest request){
        //获取所有评论信息
        // content: $("#content").val(),
        // name: $("#name").val(),
        // email: $("#email").val(),
        // articleId: $("#articleId").val(),
        String content = request.getParameter("content");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Long articleId = Long.parseLong(request.getParameter("articleId"));

        //创建评论对象
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setContent(content);
        comment.setDate(new Date());
        comment.setEmail(email);
        comment.setName(name);

        //添加评论
        int i = commentService.insetComment(comment);

        //创建返回对象
        Map<String,String> map = new HashMap<>();
        if(i>0){
            //评论成功
            map.put("stateCode","1");
        }
        else{
            map.put("stateCode","0");
        }

        return map;
    }

    /**
     * 删除评论
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/comment/del",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> commentDel(String id){
        //创建信息返回对象
        Map<String,String> map = new HashMap<>();

        Long commentId = Long.parseLong(id);
        int i = commentService.deleteCommentById(commentId);

        if(i > 0){
            map.put("stateCode","1");
            return map;
        }

        map.put("stateCode","0");
        return map;
    }

}
