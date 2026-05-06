package org.example.firstrestapiproject.support;

import org.springframework.stereotype.Component;
import org.example.firstrestapiproject.api.request.ProductRequest;
import org.example.firstrestapiproject.api.response.ProductResponse;
import org.example.firstrestapiproject.domain.Product;

@Component

public class ProductMapper {
    public Product toProduct(ProductRequest productRequest){
        return new Product(productRequest.getName());
    }

    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(product.getId(),product.getName());
    }


}
