package com.example.demo.core.controller;

import com.example.demo.core.domain.User;
import com.example.demo.core.exception.UsuarioExistenteException;
import com.example.demo.core.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.net.URI;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "usuario")
@CrossOrigin(value = "*")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<String>> get() {
        List<User> user = userService.findByName();
        List<String> nomes = user.stream()
                .map(User::getNome)
                .distinct()
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(nomes);
    }

    @RequestMapping(value = "/filtro/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        List<User> user = userService.findAll();
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/registrar-usuario", method = RequestMethod.POST)
    public ResponseEntity<?> insetUsuario(@Valid @RequestBody User user) throws UsuarioExistenteException {
        user = userService.insert(user);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }
}
