package zaru.br.demo.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import zaru.br.demo.core.enuns.RoleEnuns;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String login;
    private String senha;
    private String nome;
    private RoleEnuns role;

    public User(String login, String senha, String nome, RoleEnuns role) {
        this.login = login;
        this.nome  = nome;
        this.role  = role;
        this.senha = senha;
    }
}
