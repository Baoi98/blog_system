package com.ronin.blog.service.impl;

import com.ronin.blog.entity.AdminLoginLog;
import com.ronin.blog.mapper.AdminLoginLogMapper;
import com.ronin.blog.service.AdminLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:31
 */
@Service
public class AdminLoginLogServiceImpl implements AdminLoginLogService {

    @Autowired
    private AdminLoginLogMapper adminLoginLogMapper;

    @Override
    public void insert(AdminLoginLog adminLoginLog) {
        int i = adminLoginLogMapper.insert(adminLoginLog);
    }

    @Override
    public AdminLoginLog selectLoginLogByAdminId(Integer adminId) {
        AdminLoginLog adminLoginLog = adminLoginLogMapper.selectLastLoginLogByAdminId(adminId);
        return adminLoginLog;
    }

    @Override
    public Integer adminLoginCountById(Integer adminId) {
        return adminLoginLogMapper.adminLoginCountById(adminId);
    }
}
