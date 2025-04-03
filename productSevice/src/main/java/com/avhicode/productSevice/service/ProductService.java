package com.avhicode.productSevice.service;

import com.avhicode.productSevice.model.ProductRequest;
import com.avhicode.productSevice.model.ProductResponse;
import org.springframework.stereotype.Service;


public interface ProductService {
    long addProduct(ProductRequest productRequest);

    ProductResponse getProductById(long productId);

    void reduceQuantity(long productId, long quantity);
}
