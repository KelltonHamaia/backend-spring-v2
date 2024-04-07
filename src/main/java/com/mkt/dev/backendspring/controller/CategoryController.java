package com.mkt.dev.backendspring.controller;

import com.mkt.dev.backendspring.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private CategoryServices categoryServices;

}
