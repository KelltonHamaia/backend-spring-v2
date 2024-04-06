package com.mkt.dev.backendspring.repository;

import com.mkt.dev.backendspring.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
