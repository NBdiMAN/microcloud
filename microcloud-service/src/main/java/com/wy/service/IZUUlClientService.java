package com.wy.service;


import com.wy.feign.FeignClientConfig;
import com.wy.service.fallback.IZUUlClientServiceallbackFactory;
import com.wy.vo.Product;
import com.wy.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "MICROCLOUD-ZUUL-GATEWAY",configuration = FeignClientConfig.class,
        fallbackFactory = IZUUlClientServiceallbackFactory.class)
public interface IZUUlClientService {

    @RequestMapping("/product-proxy/product/get/{id}")
    public Product getProduct(@PathVariable("id")long id);

    @RequestMapping("/product-proxy/product/list")
    public List<Product> listProduct() ;

    @RequestMapping("/product-proxy/product/add")
    public boolean addPorduct(Product product) ;

    @RequestMapping("/user-proxy/user/get/{name}")
    public User getUsers(@PathVariable("name")String name);
}