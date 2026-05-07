package org.example.firstrestapiproject.support;

import org.example.firstrestapiproject.api.request.UpdateProductRequest;
import org.springframework.stereotype.Component;
import org.example.firstrestapiproject.api.request.ProductRequest;
import org.example.firstrestapiproject.api.response.ProductResponse;
import org.example.firstrestapiproject.domain.Product;

@Component

public class ProductMapper {
    public Product toProduct(ProductRequest productRequest){

        return new Product(productRequest.getName());
    }


    public Product toProduct(Product product, UpdateProductRequest updateProductRequest){
        product.setName(updateProductRequest.getName());
        return product;
    }

    public ProductResponse toProductResponse(Product product){
        return new ProductResponse(product.getId(),product.getName());
    }




}
