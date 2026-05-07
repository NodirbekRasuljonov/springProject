package org.example.firstrestapiproject.service;
import org.springframework.stereotype.Service;
import org.example.firstrestapiproject.repository.ProductRepository;
import org.example.firstrestapiproject.api.request.ProductRequest;
import org.example.firstrestapiproject.api.response.ProductResponse;
import org.example.firstrestapiproject.domain.Product;
import org.example.firstrestapiproject.support.ProductMapper;



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
        Product product=productRepository.findByID(id).orElseThrow(RuntimeException::new);
        return productMapper.toProductResponse(product);
    }



}
