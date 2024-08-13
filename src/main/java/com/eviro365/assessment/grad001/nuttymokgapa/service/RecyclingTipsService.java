package com.eviro365.assessment.grad001.nuttymokgapa.service;

import com.eviro365.assessment.grad001.nuttymokgapa.model.RecyclingTips;
import com.eviro365.assessment.grad001.nuttymokgapa.repository.RecyclingTipsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingTipsService {
/**
 * The service function uses the interface class to retrieve all
 * queried functions in the controller.
 * */
    @Autowired
    private RecyclingTipsRepository repository;

    public List<RecyclingTips> getAllTips() {
        return repository.findAll();
    }

    public RecyclingTips getTipById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public RecyclingTips saveTip(RecyclingTips recyclingTips) {
        return repository.save(recyclingTips);
    }

    public void deleteTip(Long id) {
        repository.deleteById(id);
    }
}
