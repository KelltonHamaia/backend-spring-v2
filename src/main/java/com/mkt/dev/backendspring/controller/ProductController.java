package com.mkt.dev.backendspring.controller;

import com.mkt.dev.backendspring.model.Product;
import com.mkt.dev.backendspring.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductServices productServices;
    @GetMapping(path = "/all")
    public Iterable<Product> getAll() {
        return productServices.getAllProducts();
    }

    @GetMapping(path = "/lastupdated")
    public Iterable<Product> getLastUpdatedProducts() {
        return productServices.getUpdatedProductsFromYesterday();
    }

    @PostMapping(path = "/add")
    public String createNewProduct(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam int stock,
            @RequestParam Long category_id
    ) {
        return productServices.createNewProduct(name, description, stock, category_id);
    }


    @PostMapping(path = "/update")
    public String updateProduct(
            @RequestParam Long id,
            @RequestParam(required = false) String new_name,
            @RequestParam(required = false) String new_description,
            @RequestParam(required = false) Optional<Integer> new_stock,
            @RequestParam(required = false) Long new_category_id
    ) {

        return productServices.updateProduct(id, new_name, new_description, new_stock, new_category_id);
    }

}
