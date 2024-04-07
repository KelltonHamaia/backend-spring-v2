package com.mkt.dev.backendspring.services;

import com.mkt.dev.backendspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRP;

}
