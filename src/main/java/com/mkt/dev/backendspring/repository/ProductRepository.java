package com.mkt.dev.backendspring.repository;

import com.mkt.dev.backendspring.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;

public interface ProductRepository extends CrudRepository<Product, Long> {
    Iterable<Product> findByUpdatedAtAfter(Date yesterday);
}
