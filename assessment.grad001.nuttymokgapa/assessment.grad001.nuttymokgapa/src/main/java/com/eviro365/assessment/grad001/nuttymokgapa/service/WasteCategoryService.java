package com.eviro365.assessment.grad001.nuttymokgapa.service;

import com.eviro365.assessment.grad001.nuttymokgapa.model.WasteCategory;
import com.eviro365.assessment.grad001.nuttymokgapa.repository.WasteCategotyRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class WasteCategoryService {
    /**
     * The service function uses the interface class to retrieve all
     * queried functions in the controller.
     * */
    @Autowired
    private WasteCategotyRepository repository;

    public List<WasteCategory> getAllCategories() {
        return repository.findAll();
    }

    public WasteCategory getCategoryById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public WasteCategory saveCategory(WasteCategory category) {
        return repository.save(category);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
