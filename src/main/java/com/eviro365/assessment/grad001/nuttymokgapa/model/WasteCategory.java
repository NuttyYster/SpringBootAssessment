package com.eviro365.assessment.grad001.nuttymokgapa.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WasteCategory
{
    /**
     * This function will set and get the id's, name's and
     * descriptions of our waste categories, e.g plastic, paper, etc.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    private String description;

    public WasteCategory(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
