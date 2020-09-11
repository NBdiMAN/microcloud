package com.wy.mapper;

import com.wy.vo.Product;

import java.util.List;

/**
 * @author wangyang
 * @date 2020/8/15 11:19
 * @description:
 */
public interface ProductMapper {

    boolean create(Product product);

    Product findById(Long id);

    List<Product> findAll();
}
