package com.lpdrs.decola_tech_dio.service;

import com.lpdrs.decola_tech_dio.domain.model.User;

// esse padrão service/impl (interface/classe) é feito para obedecermos ao enclausuramento em POO
// dessa forma, evitamos expor a implementação da camada de serviços.
// assim, apenas a assinatura dos métodos poderá ser vista por fora.
public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
