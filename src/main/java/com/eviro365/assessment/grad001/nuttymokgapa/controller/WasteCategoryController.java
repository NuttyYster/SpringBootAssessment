package com.eviro365.assessment.grad001.nuttymokgapa.controller;

import com.eviro365.assessment.grad001.nuttymokgapa.service.WasteCategoryService;
import com.eviro365.assessment.grad001.nuttymokgapa.model.WasteCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waste-category")
public class WasteCategoryController {
    /**
     * In this function will control the CRUD operations, using the id's,
     * using the service function object
     * */
    @Autowired
    private WasteCategoryService service;

    @GetMapping
    public List<WasteCategory> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public WasteCategory getCategoryById(Long id) {
        return service.getCategoryById(id);
    }

    @PostMapping
    public WasteCategory createCategory(@RequestBody WasteCategory category) {
        return service.saveCategory(category);
    }

    @PutMapping("/{id}")
    public WasteCategory updateCategoryById(@PathVariable Long id,@RequestBody WasteCategory category) {
        category.setId(id);
        return service.saveCategory(category);
    }

    @DeleteMapping
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }
}
