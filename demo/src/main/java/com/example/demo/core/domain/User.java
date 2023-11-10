package com.example.demo.core.domain;

import com.example.demo.core.enuns.RoleEnuns;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class User {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String login;
    private String senha;

    private Long tipo;

    private RoleEnuns role;
    @CreationTimestamp
    private LocalDateTime created;

    public User(Long id, String nome, String login, String senha, Long tipo){
        this.nome = nome;
        this.login = login;
        this.id = id;
        this.senha = senha;
        this.tipo = tipo;
    }
    public User (String nome, String login) {
        this.nome =  nome;
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(nome, user.nome) && Objects.equals(login, user.login) && Objects.equals(senha, user.senha) && Objects.equals(created, user.created);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, login, senha, created);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", tipo='" + tipo + '\'' +
                ", created=" + created +
                '}';
    }
}
