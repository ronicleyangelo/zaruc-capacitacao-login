package com.example.demo.core.repository;

import com.example.demo.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional(readOnly = true)
    @Query("SELECT distinct obj FROM User obj WHERE LOWER(obj.login) = LOWER(:login)")
    User findByLogin(@Param("login") String login);

}
