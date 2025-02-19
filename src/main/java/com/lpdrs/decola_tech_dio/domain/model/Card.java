package com.lpdrs.decola_tech_dio.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String number;

    // limit tá recebendo nome diferente porque em algumas DBs pode ser um nome reservado.
    @Column(name = "available_limit", precision = 13, scale = 2) // precision é o número de decimais
    private BigDecimal limit;
}
