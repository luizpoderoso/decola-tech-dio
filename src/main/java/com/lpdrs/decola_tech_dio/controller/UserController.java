package com.lpdrs.decola_tech_dio.controller;

import com.lpdrs.decola_tech_dio.domain.model.User;
import com.lpdrs.decola_tech_dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    // injeção de dependências via construtor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        var userCreated = userService.create(user);

        // conseguir a localização na URI (URL) de qual endpoint na API podemos acessar o valor recém-criado.
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();

        // apontar que foi criado na localização '/users/{id}' e mandar a resposta pelo body.
        return ResponseEntity.created(location).body(userCreated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        var user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
