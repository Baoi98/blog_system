package com.ronin.blog.service.impl;

import com.ronin.blog.entity.Catalog;
import com.ronin.blog.mapper.CatalogMapper;
import com.ronin.blog.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 98
 * @Date: 2019-5-20 10:07
 */
@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogMapper catalogMapper;

    @Override
    public List<Catalog> findAllCatalog() {
        return catalogMapper.findAllCatalog();
    }
}
