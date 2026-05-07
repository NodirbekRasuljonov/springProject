package org.example.firstrestapiproject.service;
import org.example.firstrestapiproject.api.request.UpdateProductRequest;
import org.example.firstrestapiproject.support.ProductExcaptionSupplier;
import org.springframework.stereotype.Service;
import org.example.firstrestapiproject.repository.ProductRepository;
import org.example.firstrestapiproject.api.request.ProductRequest;
import org.example.firstrestapiproject.api.response.ProductResponse;
import org.example.firstrestapiproject.domain.Product;
import org.example.firstrestapiproject.support.ProductMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id){
        Product product=productRepository.findById(id).orElseThrow(ProductExcaptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }
    public ProductResponse updateProduct(Long id, UpdateProductRequest updateProductRequest){
        Product product=productRepository.findById(id).orElseThrow(ProductExcaptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }

    public List<ProductResponse> findAll(){
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());

    }

    public void delete(Long id){
        Product product=productRepository.findById(id).orElseThrow(ProductExcaptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}
