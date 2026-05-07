package org.example.firstrestapiproject.support;

import org.example.firstrestapiproject.support.excaption.ProductNotFoundExcaption;

import java.util.function.Supplier;

public class ProductExcaptionSupplier {
    public static Supplier<ProductNotFoundExcaption>productNotFound(Long id){
        return () -> new ProductNotFoundExcaption(id);
    }
}
