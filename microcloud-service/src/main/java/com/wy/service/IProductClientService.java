package com.wy.service;

import com.wy.feign.FeignClientConfig;
import com.wy.service.fallback.IProductClientServiceFallbackFactory;
import com.wy.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author wangyang
 * @date 2020/8/19 17:48
 * @description:
 */
@FeignClient(name = "MICROCLOUD-PROVIDER-PRODUCT",configuration = FeignClientConfig.class,fallbackFactory = IProductClientServiceFallbackFactory.class)
public interface IProductClientService {
    @RequestMapping("/product/get/{id}")
    Product getProduct(@PathVariable("id")Long id);

    @RequestMapping("/product/list")
    List<Product> listProduct();


    @RequestMapping("/product/add")
    boolean addProduct(Product product);
}
