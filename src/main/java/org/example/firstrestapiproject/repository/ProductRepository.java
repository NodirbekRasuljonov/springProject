package org.example.firstrestapiproject.repository;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.example.firstrestapiproject.domain.Product;

@Repository

public class ProductRepository {
    protected final Map<Long,Product> map = new HashMap<>();
    protected long counter=1;
    public Product save(Product entity){
        setId(entity);
        return entity;
    }

    private Product setId(Product entity){
        entity.setId(counter);
        map.put(counter,entity);
        counter++;
        return entity;
    }

    public Optional<Product> findByID(Long id){
        return Optional.ofNullable(map.get(id));
    }



}
