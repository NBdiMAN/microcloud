package com.wy.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getFallBack")//如果发生异常，就调用制定方法，参数和返回值需要和原方法相同
    public Product get(@PathVariable("id") Long id){
        Product product = productService.get(id);
        if(product == null){
            throw new RuntimeException("该产品已下架！");
        }
        return productService.get(id);
    }

    public Product getFallBack(@PathVariable("id") Long id){
        Product product = new Product();
        product.setProductId(0L);
        product.setProductName("hystrixName");
        product.setProductDesc("hystrixDesc");
        return product;
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
