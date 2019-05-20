package com.ronin.blog.mapper;

import com.ronin.blog.entity.Admin;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * 根据管理员账号查找管理员
     * @param adminName
     * @return
     */
    Admin selectByAdminName(String adminName);
}