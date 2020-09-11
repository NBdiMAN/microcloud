package com.wy.test;

import com.wy.StreamProviderApp;
import com.wy.service.IMessageProvider;
import com.wy.vo.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wangyang
 * @date 2020/8/31 17:44
 * @description:
 */
@SpringBootTest(classes = StreamProviderApp.class)
@RunWith(SpringRunner.class)
public class TestMessageProvider {
    @Autowired
    private IMessageProvider messageProvider;

    @Test
    public void testSend(){
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("java");
        product.setProductDesc("springcloud");
        messageProvider.send(product);
    }
}
