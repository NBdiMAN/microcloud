package com.wy.controller;

import com.wy.vo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author wangyang
 * @date 2020/8/15 13:35
 * @description:
 */
@RestController
@RequestMapping(value = "/consumer")
public class ConsumerProductController {
    public static final String PRODUCT_GET_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/get/";
    public static final String PRODUCT_LIST_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/list";
    public static final String PRODUCT_ADD_URL = "http://MICROCLOUD-PROVIDER-PRODUCT/product/add";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpHeaders httpHeaders;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping(value = "/product/get")
    public Product getProduct(Long id){
        Product product = restTemplate.exchange(PRODUCT_GET_URL + id, HttpMethod.GET, new HttpEntity(httpHeaders), Product.class).getBody();
        return product;
    }

    @RequestMapping(value = "/product/list")
    public List<Product> listProduct(Long id){
        ServiceInstance choose = loadBalancerClient.choose("MICROCLOUD-PROVIDER-PRODUCT");
        System.out.println("host:" + choose.getHost() + ",port: " + choose.getPort() + ",serviceId: " + choose.getServiceId());
        List<Product> products = restTemplate.exchange(PRODUCT_LIST_URL, HttpMethod.GET, new HttpEntity(httpHeaders), List.class).getBody();
        return products;
    }

    @RequestMapping(value = "/product/add")
    public Boolean addProduct(Product product){
        Boolean result = restTemplate.exchange(PRODUCT_ADD_URL, HttpMethod.POST, new HttpEntity(product,httpHeaders), Boolean.class).getBody();
        return result;
    }
}
