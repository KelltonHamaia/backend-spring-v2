package com.mkt.dev.backendspring.services;

import com.mkt.dev.backendspring.model.Category;
import com.mkt.dev.backendspring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServices {
    @Autowired
    private CategoryRepository categoryRP;

    public Iterable<Category> getAllCategories() {
        return categoryRP.findAll();
    }
    public String createNewCategory(String categoryName) {
        Optional<Category> category = categoryRP.findByName(categoryName);
        if(category.isPresent()) return "This category already exists.";

        Category newCategory = new Category(categoryName);
        categoryRP.save(newCategory);
        return "success";
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRP.findById(id);
    }

    public String updateCategory(Long id, String categoryName) {
        Optional<Category> category = categoryRP.findById(id);
        if(category.isEmpty()) return "Category not found.";

        if(categoryName != null) {
            category.get().setName(categoryName);
            categoryRP.save(category.get());
        }
        return "Category successfully updated.";
    }
    public String deleteCategory(Long id) {
        Optional<Category> category = categoryRP.findById(id);

        if(category.isEmpty()) return "Category not found";

        categoryRP.delete(category.get());
        return "Category deleted";
    }
}
