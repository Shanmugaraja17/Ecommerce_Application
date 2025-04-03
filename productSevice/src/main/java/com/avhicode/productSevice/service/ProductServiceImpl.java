package com.avhicode.productSevice.service;

import com.avhicode.productSevice.entity.Product;
//import com.avhicode.productSevice.exception.ProductServiceCustomException;
import com.avhicode.productSevice.model.ProductRequest;
import com.avhicode.productSevice.model.ProductResponse;
import com.avhicode.productSevice.repository.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public long addProduct(ProductRequest productRequest) {

        Product product = Product.builder()
                .productName(productRequest.getName())
                .price(productRequest.getPrice())
                .quantity(productRequest.getQuantity())
                .build();

        productRepository.save(product);

        log.info("Product is created.... ");

        return product.getProductId();
    }

    @Override
    public ProductResponse getProductById(long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new RuntimeException("Product with given ID is not found"));

        ProductResponse productResponse =  new ProductResponse();

        BeanUtils.copyProperties(product, productResponse);

        return productResponse;
    }

    @Override
    public void reduceQuantity(long productId, long quantity) {
        Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found with given ID"));

        if(product.getQuantity()<quantity){
            throw new RuntimeException("Product doesn't have sufficient quantity");
        }

        product.setQuantity(product.getQuantity()-quantity);
        productRepository.save(product);
        log.info("Product quantity reduces successfully");
    }
}
