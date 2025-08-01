package com.lpdrs.decola_tech_dio.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity(name = "tb_account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // constraint para o número da conta ser único
    @Column(unique = true)
    private String number;

    private String agency;

    // total de 13 números. ex: 12345678901.23 (11 inteiros + 2 decimais)
    @Column(precision = 13, scale = 2) // precision é o número de decimais
    private BigDecimal balance;

    // limit tá recebendo nome diferente porque em algumas DBs pode ser um nome reservado.
    @Column(name = "additional_limit", precision = 13, scale = 2) // precision é o número de decimais
    private BigDecimal limit;
}
