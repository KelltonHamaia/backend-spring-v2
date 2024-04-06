package com.mkt.dev.backendspring.repository;

import com.mkt.dev.backendspring.model.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
}
