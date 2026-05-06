package org.example.firstrestapiproject.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.firstrestapiproject.api.request.ProductRequest;
import org.example.firstrestapiproject.api.response.ProductResponse;
import org.example.firstrestapiproject.service.ProductService;


@RestController
@RequestMapping("/api/v1/products")



public class ProductController {
    private final ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse=productService.createProduct(productRequest);
        return new ResponseEntity<>(productResponse,HttpStatus.CREATED);
    }

}
