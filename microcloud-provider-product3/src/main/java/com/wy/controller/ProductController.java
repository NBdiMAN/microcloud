package com.wy.controller;

import com.wy.service.IProductService;
import com.wy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wangyang
 * @date 2020/8/15 11:50
 * @description:
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/get/{id}")
    public Product get(@PathVariable("id") Long id){
        return productService.get(id);
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public boolean add(@RequestBody Product product){
        return productService.add(product);
    }

    @RequestMapping(value = "/list")
    public List<Product> list(){
        return productService.list();
    }

    @RequestMapping(value = "/discover")
    public DiscoveryClient discover(){
        return client;
    }
}
