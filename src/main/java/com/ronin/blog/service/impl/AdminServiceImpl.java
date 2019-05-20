package com.ronin.blog.service.impl;

import com.ronin.blog.entity.Admin;
import com.ronin.blog.mapper.AdminMapper;
import com.ronin.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * @Author: 98
 * @Date: 2019-5-17 22:31
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String adminName, String password) {
        //查找数据库
        Admin admin = adminMapper.selectByAdminName(adminName);

        //判断管理员是否为空，为空则返回用户不存在，参数为0
        if(admin == null){
            admin.setUsername("用户不存在");
            return admin;
        }

        //判断输入的密码与MD5密码是否一致
        String MD5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!MD5Password.equals(admin.getPassword())){
            admin.setPassword("密码错误");
            return admin;
        }

        return admin;
    }

}
