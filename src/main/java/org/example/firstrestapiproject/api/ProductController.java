package org.example.firstrestapiproject.api;

import io.swagger.v3.oas.annotations.Operation;
import org.example.firstrestapiproject.api.request.UpdateProductRequest;
import org.example.firstrestapiproject.repository.ProductRepository;
import org.example.firstrestapiproject.support.ProductMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.example.firstrestapiproject.api.request.ProductRequest;
import org.example.firstrestapiproject.api.response.ProductResponse;
import org.example.firstrestapiproject.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shared/response/api/v1/products")
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
    @PutMapping("/{id}")
    @Operation(summary = "Update Product")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest){
        ProductResponse productResponse=productService.updateProduct(id,updateProductRequest);
        return ResponseEntity.status(HttpStatus.OK).body(productResponse);
    }

    @GetMapping
    @Operation(summary = "Find allproducts")
    public ResponseEntity<List<ProductResponse>> findAll(){
        List<ProductResponse> productResponses=productService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(productResponses);

    }
    @DeleteMapping("/{id}")
    @Operation(summary = "Delere Products")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }







}
