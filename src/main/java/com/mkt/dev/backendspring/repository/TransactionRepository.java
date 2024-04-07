package com.mkt.dev.backendspring.repository;

import com.mkt.dev.backendspring.model.Category;
import com.mkt.dev.backendspring.model.QuantityProductsDTO;
import com.mkt.dev.backendspring.model.Transaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;
public interface TransactionRepository extends CrudRepository<Transaction, Long> {
    Iterable<Transaction> findByProduct_Category(Category category);
    @Query(
            "select " +
            "new com.mkt.dev.backendspring.model.QuantityProductsDTO(p.name, count(*)) " +
            "from Transaction t join Product p on t.product = p where p.category.id = :category_id group by p.name"
    )
    List<QuantityProductsDTO> getTransactionRelatory(@Param("category_id") Long category_id);

}
