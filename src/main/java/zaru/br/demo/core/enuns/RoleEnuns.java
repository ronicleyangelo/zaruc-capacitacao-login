package zaru.br.demo.core.enuns;

import lombok.Getter;

@Getter
public enum RoleEnuns {
    ADMIN("admin"),
    USER("user");

    private String role;
    RoleEnuns(String role) {
        this.role = role;
    }
}
