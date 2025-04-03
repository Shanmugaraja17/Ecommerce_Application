package com.avhicode.productSevice.controller;

import com.avhicode.productSevice.model.ProductRequest;
import com.avhicode.productSevice.model.ProductResponse;
import com.avhicode.productSevice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest){

        long productId = productService.addProduct(productRequest);

        return new ResponseEntity<>(productId, HttpStatus.CREATED);

    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductByID(@PathVariable long productId){

        ProductResponse productResponse = productService.getProductById(productId);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);

    }

    @PutMapping("/reducequantity/{id}")
    public ResponseEntity<Void> reduceQuantity(
            @PathVariable("id") long productId, @RequestParam long quantity)
    {
        productService.reduceQuantity(productId,quantity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
