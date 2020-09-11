package com.wy.service;

import com.wy.vo.Product;

import java.util.List;

/**
 * @author wangyang
 * @date 2020/8/15 11:40
 * @description:
 */
public interface IProductService {
    Product get(Long id);

    boolean add(Product product);

    List<Product> list();
}
