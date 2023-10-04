package zaru.br.demo.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zaru.br.demo.core.domain.User;
import zaru.br.demo.core.dto.UserDTO;
import zaru.br.demo.core.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUsuario(String login) {
        return userRepository.findByName(login);
    }

    public User insert(User userDTO) {
        return userRepository.save(userDTO);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public void updateUsuario(User user) {
        userRepository.save(user);
    }
}
