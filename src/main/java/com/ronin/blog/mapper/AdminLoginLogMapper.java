package com.ronin.blog.mapper;

import com.ronin.blog.entity.AdminLoginLog;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminLoginLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(AdminLoginLog record);

    int insertSelective(AdminLoginLog record);

    AdminLoginLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(AdminLoginLog record);

    int updateByPrimaryKey(AdminLoginLog record);

    /**
     * 通过管理员ID查找最后一次登陆信息
     * @param adminId
     * @return
     */
    AdminLoginLog selectLastLoginLogByAdminId(Integer adminId);

    /**
     * 通过管理员ID查找管理员登陆次数
     * @param adminId
     * @return
     */
    Integer adminLoginCountById(Integer adminId);

}