package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    private String firstName;
    private String lastName;

    @NotBlank(message = "Favor inserir um e-mail válido")
    private String email;

    @Setter(AccessLevel.NONE)
    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(User entity){
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();

        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }
}
