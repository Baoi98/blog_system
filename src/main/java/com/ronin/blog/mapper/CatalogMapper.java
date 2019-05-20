package com.ronin.blog.mapper;

import com.ronin.blog.entity.Catalog;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CatalogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Catalog record);

    int insertSelective(Catalog record);

    Catalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Catalog record);

    int updateByPrimaryKeyWithBLOBs(Catalog record);

    int updateByPrimaryKey(Catalog record);

    /**
     * 查找所有栏目信息
     * @return
     */
    List<Catalog> findAllCatalog();
}