package com.lpdrs.decola_tech_dio.service.impl;

import com.lpdrs.decola_tech_dio.domain.model.User;
import com.lpdrs.decola_tech_dio.domain.repository.UserRepository;
import com.lpdrs.decola_tech_dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        // caso não ache o user, enviar a exceção NoSuchElementException.
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        Long id = userToCreate.getId();
        String accountNumber = userToCreate.getAccount().getNumber();

        if (id != null && userRepository.existsById(id) )
            throw new IllegalArgumentException("Um usuário com esse id já existe.");

        if (accountNumber != null && userRepository.existsByAccountNumber(accountNumber))
            throw new IllegalArgumentException("Um usuário com essa conta bancária já existe.");

        return userRepository.save(userToCreate);
    }
}
