package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String authority;

    public RoleDTO(Role role){
        id = role.getId();
        authority = role.getAuthority();
    }
}
