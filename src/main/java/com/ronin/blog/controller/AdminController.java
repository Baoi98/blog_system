package com.ronin.blog.controller;

import com.ronin.blog.entity.Admin;
import com.ronin.blog.entity.AdminLoginLog;
import com.ronin.blog.service.AdminLoginLogService;
import com.ronin.blog.service.AdminService;
import com.ronin.blog.service.ArticleService;
import com.ronin.blog.service.CommentService;
import com.ronin.blog.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理员控制器
 * @Author: 98
 * @Date: 2019-5-17 23:33
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminLoginLogService adminLoginLogService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private ArticleService articleService;

    /**
     * 跳转到登陆页
     * @return
     */
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index(){
        return "admin/login";
    }


    /**
     * 管理员登陆
     * @param request
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,String> login(HttpServletRequest request){
        //创建返回参数对象
        Map<String,String> map = new HashMap<>();
        //获取登陆参数
        // id:$("#adminName").val()
        // password: $("#password").val()
        String adminName = request.getParameter("adminName");
        String password = request.getParameter("password");

        //验证参数可靠性
        if(StringUtils.isEmpty(adminName) || StringUtils.isEmpty(password)){
            //-1为参数错误
            map.put("stateCode","-1");
            return map;
        }

        //登陆功能
        Admin admin = adminService.login(adminName, password);

        if("用户不存在".equals(admin.getUsername())){
            map.put("stateCode","0");
            return map;
        }
        else if("密码错误".equals(admin.getPassword())){
            map.put("stateCode","1");
            return map;
        }

        //登陆成功
        map.put("stateCode","2");
        //存放管理员信息
        request.getSession().setAttribute("admin",admin);
        //添加管理员登陆信息
        String ipAddress = getIpAddress(request);

        AdminLoginLog adminLoginLog = new AdminLoginLog();
        adminLoginLog.setAdminId(admin.getId());
        adminLoginLog.setIp(ipAddress);
        adminLoginLog.setDate(new Date());

        adminLoginLogService.insert(adminLoginLog);

        return map;
    }

    /**
     * 管理员主页
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String main(HttpServletRequest request, Model model){

        //获取登陆的IP信息
        String ipAddress = getIpAddress(request);
        //服务器IP
        String localAddr = request.getLocalAddr();
        //服务器端口
        int serverPort = request.getServerPort();
        //当前登陆时间
        String date = DateUtil.getLongDate(new Date());

        //从session域中获取管理员信息
        Admin admin = (Admin) request.getSession().getAttribute("admin");
        Integer adminId = admin.getId();
        //通过管理员ID查找管理员最近一条登陆信息
        AdminLoginLog adminLoginLog = null;
        try {
            adminLoginLog = adminLoginLogService.selectLoginLogByAdminId(adminId);
        } catch (Exception e) {
            logger.error("管理员登陆信息有误！");
        }

        //查询文章和评论总数，管理员登陆次数
        Integer articleCount = articleService.allArticleCount();
        Integer commentCount = commentService.allCommentCount();
        Integer adminLoginCount = adminLoginLogService.adminLoginCountById(adminId);

        //保存信息
        model.addAttribute("adminLoginLog",adminLoginLog);
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("commentCount",commentCount);
        model.addAttribute("adminLoginCount",adminLoginCount);
        model.addAttribute("date",date);
        model.addAttribute("serverPort",serverPort);
        model.addAttribute("localAddr",localAddr);
        model.addAttribute("ipAddress",ipAddress);

        return "admin/main";
    }

    /**
     * 管理员注销
     * @param session
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/admin/index";
    }


    /**
     * 从request中获取请求方IP
     * @param request
     * @return
     */
    private static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

}
