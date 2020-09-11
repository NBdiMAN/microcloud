package com.wy.service.fallback;

import com.wy.service.IProductClientService;
import com.wy.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;
import rx.Producer;

import java.util.List;

/**
 * @author wangyang
 * @date 2020/8/23 20:09
 * @description:
 */
@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return new IProductClientService() {
            @Override
            public Product getProduct(Long id) {
                Product product = new Product();
                product.setProductId(1L);
                product.setProductName("fallbackName");
                product.setProductDesc("fallbackDesc");
                return product;
            }

            @Override
            public List<Product> listProduct() {
                return null;
            }

            @Override
            public boolean addProduct(Product product) {
                return false;
            }
        };
    }
}
