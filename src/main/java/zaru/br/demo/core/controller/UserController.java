package zaru.br.demo.core.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import zaru.br.demo.core.domain.User;
import zaru.br.demo.core.repository.UserRepository;
import zaru.br.demo.core.service.UserService;

import java.net.URI;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
//    @RequestMapping("/")
//    public String home(){
//        return "Hello World!";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
//    @GetMapping
    public ResponseEntity<User> getUsuarios(String login){
        User user = userService.getUsuario(login);
        return ResponseEntity.ok().body(user);
    }

    @RequestMapping(value = "/registrar/usuario", method = RequestMethod.POST)
    public ResponseEntity<?> insert (@Valid @RequestBody User userDTO) {
        userDTO = userService.insert(userDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(userDTO.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> desabilitarUsuario(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/update/usuario/{id}", method = RequestMethod.PUT)
    public  ResponseEntity<?> updateUsuario(@Valid @RequestBody @NotNull User user, @PathVariable Long id) {
        user.setId(id);
        userService.updateUsuario(user);
        return ResponseEntity.noContent().build();
    }

}
