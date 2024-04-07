package com.mkt.dev.backendspring.services;

import com.mkt.dev.backendspring.model.Category;
import com.mkt.dev.backendspring.model.Product;
import com.mkt.dev.backendspring.repository.CategoryRepository;
import com.mkt.dev.backendspring.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ProductServices {
    @Autowired
    private ProductRepository productRP;
    @Autowired
    private CategoryRepository categoryRP;
    public Iterable<Product> getAllProducts() {
        return productRP.findAll();
    }
    public String createNewProduct(String name, String description, int stock, Long category_id){

        if(name.isEmpty() || description.isEmpty() || stock < 0 || category_id == null) {
            return "Please provide all the information";
        }

        Optional<Category> category = categoryRP.findById(category_id);
        if(category.isEmpty()) return "Please provide a valid ID for the category";

        Product product = new Product(name, description, stock,category.get());
        productRP.save(product);

        return "Product created successfully";
    }

    public String updateProduct( Long id, String new_name, String new_description, Optional<Integer> new_stock, Long new_category_id){
        Optional<Product> product = productRP.findById(id);
        if(product.isEmpty()) return "Product not found";

        Optional<Category> category = categoryRP.findById(new_category_id);
        if(category.isEmpty()) return "Category not found";

        Product updatedProduct = product.get();
        Category newCategory = category.get();

        if(new_name != null) updatedProduct.setName(new_name);
        if(new_description != null) updatedProduct.setDescription(new_description);
        if(new_stock.isPresent()) updatedProduct.setStock(new_stock.get());
        if(new_category_id != null) updatedProduct.setCategory(newCategory);

        productRP.save(updatedProduct);
        return "Product updated successfully.";
    }

    public Iterable<Product> getUpdatedProductsFromYesterday() {
        Date yesterday = new Date( System.currentTimeMillis() - (1000 * 60 * 60 * 24 ));
        return productRP.findByUpdatedAtAfter(yesterday);
    }

}
