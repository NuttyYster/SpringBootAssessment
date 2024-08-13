package com.eviro365.assessment.grad001.nuttymokgapa.model;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import lombok.Setter;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Setter
@Entity
public class DisposalGuidelines {
    /**
     * This function will set and get the id's, guideline's and
     * category id of our disposal guidelines.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String guideline;
    private String categoryId;

    public DisposalGuidelines(long id, String name, String description) {
    }
}
