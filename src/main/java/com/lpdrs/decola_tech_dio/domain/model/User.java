package com.lpdrs.decola_tech_dio.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "tb_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL) // relação em cascata. exemplo: se um usuário for deletado, sua conta será.
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    // um usuário tem muitas listas.     toda vez que um usuário for requisitado, ele trará junto a lista de features.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Feature> features;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;
}
