package org.example.firstrestapiproject.api;

import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "Create Product")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse=productService.createProduct(productRequest);
        return new ResponseEntity<>(productResponse,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find product by id")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable Long id){
        ProductResponse productResponse=productService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }





}
