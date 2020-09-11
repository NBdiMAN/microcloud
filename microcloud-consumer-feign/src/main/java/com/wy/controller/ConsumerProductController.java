package com.wy.controller;

import com.wy.service.IProductClientService;
import com.wy.service.IZUUlClientService;
import com.wy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangyang
 * @date 2020/8/15 13:35
 * @description:
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerProductController {

    @Autowired
    private IProductClientService productClientService;

    @Autowired
    private IZUUlClientService izuUlClientService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/product/get/{id}")
    public Product getProduct(@PathVariable("id") Long id){
        Product product = productClientService.getProduct(id);
        return product;
    }

    @RequestMapping(value = "/product/list")
    public List<Product> listProduct(Long id){
        ServiceInstance choose = loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
        System.out.println("host:" + choose.getHost() + ",port: " + choose.getPort() + ",serviceId: " + choose.getServiceId());
        List<Product> products = productClientService.listProduct();
        return products;
    }

    @RequestMapping(value = "/product/add")
    public Boolean addProduct(Product product){
        Boolean result = productClientService.addProduct(product);
        return result;
    }

    @RequestMapping(value = "/gateway/getProductAndUser")
    public Object getProductAndUser(Long id){
        Map<String, Object> result = new HashMap<>();
        result.put("product", izuUlClientService.getProduct(id));
        result.put("user", izuUlClientService.getUsers(String.valueOf(id)));
        return result;
    }
}
