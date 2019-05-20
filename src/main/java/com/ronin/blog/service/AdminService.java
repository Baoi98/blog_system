package com.ronin.blog.service;

import com.ronin.blog.entity.Admin;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:29
 */
public interface AdminService {

    /**
     * 管理员登陆
     * @param adminName
     * @param password 明文密码
     * @return
     */
    Admin login(String adminName,String password);

}
