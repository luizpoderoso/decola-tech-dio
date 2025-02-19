package com.lpdrs.decola_tech_dio.repository;

import com.lpdrs.decola_tech_dio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
