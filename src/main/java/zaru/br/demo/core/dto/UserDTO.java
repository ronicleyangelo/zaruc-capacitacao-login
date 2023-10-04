package zaru.br.demo.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zaru.br.demo.core.domain.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends User {
    private String login;
    private String senha;
}
