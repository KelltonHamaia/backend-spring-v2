package com.mkt.dev.backendspring.controller;

import com.mkt.dev.backendspring.model.Category;
import com.mkt.dev.backendspring.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

    @GetMapping(path = "/all")
    public Iterable<Category> getAllCategories() {
        return categoryServices.getAllCategories();
    }

    @GetMapping(path = "/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id) {
        return categoryServices.getCategoryById(id);
    }

    @PostMapping(path = "/add")
    public String createNewCategory(@RequestParam String categoryName) {
        return categoryServices.createNewCategory(categoryName);
    }

    @PostMapping(path = "/update")
    public String updateCategory(@RequestParam Long id, @RequestParam(required = false) String categoryName) {
        return categoryServices.updateCategory(id, categoryName);
    }


}
