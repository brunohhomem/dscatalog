package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.entities.Product;
import jakarta.validation.constraints.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class ProductDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @Size(min = 3, max = 60, message = "Nome deve ter entre 3 e 60 caracteres.")
    @NotBlank(message = "Campo requerido.")
    private String name;

    @NotBlank(message = "Campo requerido.")
    private String description;

    @Positive(message = "Preço deve ser positivo.")
    private Double price;
    private String imgUrl;

    @PastOrPresent(message = "Produto não deve ter data futura.")
    private Instant date;

    private List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl, Instant date) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
        this.date = date;
    }

    public ProductDTO(Product entity) { //construtor com entidade
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
        date = entity.getDate();
    }

    public ProductDTO(Product entity, Set<Category> categories) {
        this(entity); //chama o construtor com entidade
        categories.forEach(cat -> this.categories.add(new CategoryDTO(cat))); //pega cada elemento e adiciona na lista de categories
    }
}
