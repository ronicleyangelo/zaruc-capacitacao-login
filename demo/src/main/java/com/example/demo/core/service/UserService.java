package com.example.demo.core.service;

import com.example.demo.core.domain.User;
import com.example.demo.core.exception.UsuarioExistenteException;
import com.example.demo.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    private String senhaCriptografada(String senha) {
        String hash = BCrypt.hashpw(senha, BCrypt.gensalt());
        return hash;
    }
    public User insert(User user) throws UsuarioExistenteException {

        try {
            User usuarioExistente = userRepository.findByLogin(user.getLogin());
            if(usuarioExistente != null) {
                throw new UsuarioExistenteException("Usuário Existente");
            }
            user.setSenha(senhaCriptografada(user.getSenha()));
            return userRepository.save(user);
        } catch (DataIntegrityViolationException  e) {
            throw new UsuarioExistenteException("Erro ao salvar usuário. Usuário já existe.");
        }
    }

    public List<User> findByName() {
        return userRepository.findAll();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
