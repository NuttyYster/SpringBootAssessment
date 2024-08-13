package com.eviro365.assessment.grad001.nuttymokgapa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
public class RecyclingTips {
    /**
     * This function will set and get the id's, name's and
     * descriptions of our recycling tips.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String name;
    private String description;

    public RecyclingTips(long id, String name, String description) {
    }
}
