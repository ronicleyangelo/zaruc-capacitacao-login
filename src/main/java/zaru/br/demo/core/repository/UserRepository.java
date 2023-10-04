package zaru.br.demo.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import zaru.br.demo.core.domain.User;

@Service
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
//    UserDetails findByLogin(String login);

    @Query("SELECT distinct obj FROM User obj WHERE obj.login = :login ")
    User findByName(@Param("login") String login);
}
