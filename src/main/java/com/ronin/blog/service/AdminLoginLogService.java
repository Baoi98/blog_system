package com.ronin.blog.service;

import com.ronin.blog.entity.AdminLoginLog;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:30
 */
public interface AdminLoginLogService {

    /**
     * 添加管理员登陆信息
     * @param adminLoginLog
     * @return
     */
    void insert(AdminLoginLog adminLoginLog);


    /**
     * 通过管理员ID查找登陆信息
     * @param adminId
     * @return
     */
    AdminLoginLog selectLoginLogByAdminId(Integer adminId);

    /**
     * 通过管理员ID查找管理员登陆次数
     * @param adminId
     * @return
     */
    Integer adminLoginCountById(Integer adminId);


}
