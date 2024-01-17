package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
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
    private String name;
    public CategoryDTO(Category entity){
        id = entity.getId();
        name = entity.getName();
    }
}
