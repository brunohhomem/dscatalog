package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "Campo Obrigatório")
    @Size(min = 3, max = 60, message = "Nome deve ter entre 3 e 60 caracteres.")
    private String name;
    public CategoryDTO(Category entity){
        id = entity.getId();
        name = entity.getName();
    }
}
