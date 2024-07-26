package com.eviro365.assessment.grad001.nuttymokgapa.controller;

import com.eviro365.assessment.grad001.nuttymokgapa.model.DisposalGuidelines;
import com.eviro365.assessment.grad001.nuttymokgapa.service.DisposalGuidelineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disposal-guidelines")
public class DisposalGuidelineController {
    /**
     * In this function will control the CRUD operations, using the id's,
     * using the service function object
     * */
    @Autowired
    private DisposalGuidelineService service;

    @GetMapping
    public List<DisposalGuidelines> getAllGuidelines() {
        return service.getAllGuidelines();
    }

    @GetMapping("/{id}")
    public DisposalGuidelines getGuidelinesById(@PathVariable Long id) {
        return service.getGuidelinesById(id);
    }

    @PutMapping
    public DisposalGuidelines updateGuideline(@Validated @RequestBody DisposalGuidelines guidelines, @PathVariable Long id) {
        guidelines.setId(id);
        return service.saveGuideline(guidelines);
    }

    @PostMapping("/{id}")
    public DisposalGuidelines createGuideline(@Validated @RequestBody DisposalGuidelines guidelines) {
        return service.saveGuideline(guidelines);
    }

    @DeleteMapping
    public void deleteGuideline(@PathVariable Long id) {
        service.deleteGuideline(id);
    }
}
