package com.mkt.dev.backendspring.repository;

import com.mkt.dev.backendspring.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
