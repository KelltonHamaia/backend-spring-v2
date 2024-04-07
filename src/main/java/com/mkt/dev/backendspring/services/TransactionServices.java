package com.mkt.dev.backendspring.services;

import com.mkt.dev.backendspring.model.*;
import com.mkt.dev.backendspring.repository.CategoryRepository;
import com.mkt.dev.backendspring.repository.ProductRepository;
import com.mkt.dev.backendspring.repository.TransactionRepository;
import com.mkt.dev.backendspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServices {

    @Autowired
    private UserRepository userRP;
    @Autowired
    private ProductRepository productRP;
    @Autowired
    private CategoryRepository categoryRP;
    @Autowired
    private TransactionRepository transactionRP;


    public String createNewTransaction(Long user_id, Long product_id, TransactionAction action, int quantity){

        Optional<User> userExists = userRP.findById(user_id);
        if(userExists.isEmpty()) return "User doesn't exists";

        Optional<Product> productExists = productRP.findById(product_id);
        if(productExists.isEmpty()) return "Product doesn't exists";

        Product product = productExists.get();

        if(quantity == 0) return "Quantity should be different than zero";

        Transaction transaction = new Transaction();
        transaction.setUser(userExists.get());
        transaction.setProduct(product);
        transaction.setAction(action);
        transaction.setQuantity(quantity);

        switch (action) {
            case REFILL -> {
                product.setStock( product.getStock() + quantity );
                productRP.save(product);
            }

            case SALE -> {
                product.setStock( product.getStock() - quantity );
                productRP.save(product);
            }
        }
        transactionRP.save(transaction);
        return "Transaction successfully created.";
    }

    public Iterable<Transaction> getAlltransactions() {
        return transactionRP.findAll();
    }

    public Iterable<Transaction> getTransactionsByCategory(Long category_id) {
        Optional<Category> categoryExists = categoryRP.findById(category_id);
        if(categoryExists.isEmpty()) return null;

        return transactionRP.findByProduct_Category(categoryExists.get());
    }

    public List<QuantityProductsDTO> getTransactionsRelatory(Long category_id) {
        return transactionRP.getTransactionRelatory(category_id);
    }

}
