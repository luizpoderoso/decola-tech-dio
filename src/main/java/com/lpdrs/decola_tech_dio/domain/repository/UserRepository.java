package com.lpdrs.decola_tech_dio.domain.repository;

import com.lpdrs.decola_tech_dio.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // o próprio JPA entende como fazer isso.
    boolean existsByAccountNumber(String accountNumber);
}
