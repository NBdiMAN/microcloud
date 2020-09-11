package com.wy.service;

import com.wy.vo.Product;

/**
 * @author wangyang
 * @date 2020/8/31 17:05
 * @description:
 */
public interface IMessageProvider {
    void send(Product product);
}
