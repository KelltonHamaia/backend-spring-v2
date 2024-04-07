package com.mkt.dev.backendspring.controller;

import com.mkt.dev.backendspring.model.QuantityProductsDTO;
import com.mkt.dev.backendspring.model.Transaction;
import com.mkt.dev.backendspring.model.TransactionAction;
import com.mkt.dev.backendspring.services.TransactionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {
    @Autowired
    private TransactionServices transactionServices;
    @PostMapping(path = "/add")
    public String createNewTransaction(
            @RequestParam Long user_id,
            @RequestParam Long product_id,
            @RequestParam TransactionAction action,
            @RequestParam int quantity
    ){
        return transactionServices.createNewTransaction(user_id, product_id, action, quantity);
    }

    @GetMapping(path = "/all")
    public Iterable<Transaction> getAllTransactions() {
        return transactionServices.getAlltransactions();
    }

    @GetMapping(path = "/category")
    public Iterable<Transaction> getTransactionsByCategory(@RequestParam Long category_id) {
        return transactionServices.getTransactionsByCategory(category_id);
    }

    @GetMapping(path = "/relatoryByCategory")
    public List<QuantityProductsDTO> generateRelatoryByCategory(
            @RequestParam Long category_id
    ) {
        return transactionServices.getTransactionsRelatory(category_id);
    }

}
