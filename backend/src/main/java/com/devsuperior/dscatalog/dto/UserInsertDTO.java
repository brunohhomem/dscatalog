package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserInsertDTO extends UserDTO {
    @Serial
    private static final long serialVersionUID = 1L;

    private String password;
}
