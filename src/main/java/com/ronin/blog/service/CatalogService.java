package com.ronin.blog.service;

import com.ronin.blog.entity.Catalog;

import java.util.List;

/**
 * @Author: 98
 * @Date: 2019-5-20 10:06
 */
public interface CatalogService {

    /**
     * 查找所有栏目信息
     * @return
     */
    List<Catalog> findAllCatalog();

}
