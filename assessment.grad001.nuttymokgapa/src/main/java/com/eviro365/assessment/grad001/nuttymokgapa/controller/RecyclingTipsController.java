package com.eviro365.assessment.grad001.nuttymokgapa.controller;

import com.eviro365.assessment.grad001.nuttymokgapa.model.RecyclingTips;
import com.eviro365.assessment.grad001.nuttymokgapa.model.WasteCategory;
import com.eviro365.assessment.grad001.nuttymokgapa.service.RecyclingTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recycling-tips")
public class RecyclingTipsController {
    /**
     * In this function will control the CRUD operations, using the id's,
     * using the service function object
     * */
    @Autowired
    private RecyclingTipsService service;

    @GetMapping
    public List<RecyclingTips> getAllTips() {
        return service.getAllTips();
    }

    @GetMapping("/{id}")
    public RecyclingTips getTipById(Long id) {
        return service.getTipById(id);
    }

    @PostMapping
    public RecyclingTips createTip(@RequestBody RecyclingTips tips) {
        return service.saveTip(tips);
    }

    @PutMapping("/{id}")
    public RecyclingTips updateTipById(@PathVariable Long id,@RequestBody RecyclingTips tips) {
        tips.setId(id);
        return service.saveTip(tips);
    }

    @DeleteMapping
    public void deleteTip(@PathVariable Long id) {
        service.deleteTip(id);
    }
}
