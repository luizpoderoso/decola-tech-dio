package com.lpdrs.decola_tech_dio.domain.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

// essa classe serve de base para as classes "feature" e "news"
// Dry (enxugar código)
@Data
@MappedSuperclass
public class BaseItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;
    private String description;
}
