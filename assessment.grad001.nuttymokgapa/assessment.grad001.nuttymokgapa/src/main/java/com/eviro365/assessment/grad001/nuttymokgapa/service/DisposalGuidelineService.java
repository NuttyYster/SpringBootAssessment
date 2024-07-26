package com.eviro365.assessment.grad001.nuttymokgapa.service;

import com.eviro365.assessment.grad001.nuttymokgapa.model.DisposalGuidelines;
import com.eviro365.assessment.grad001.nuttymokgapa.repository.DisposalGuidelineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisposalGuidelineService {
    /**
     * The service function uses the interface class to retrieve all
     * queried functions in the controller.
     * */
    @Autowired
    private DisposalGuidelineRepository repository;

    public List<DisposalGuidelines> getAllGuidelines() {
        return repository.findAll();
    }

    public DisposalGuidelines getGuidelinesById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public DisposalGuidelines saveGuideline(DisposalGuidelines guidelines) {
        return repository.save(guidelines);
    }

    public void deleteGuideline(Long id) {
        repository.deleteById(id);
    }

}
