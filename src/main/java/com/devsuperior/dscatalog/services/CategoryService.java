package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //registra a classe como um componente de injeção de dependencia
public class CategoryService {
    @Autowired private CategoryRepository categoryRepository;
    @Transactional(readOnly = true)
    public List<Category> findAll(){return categoryRepository.findAll();}
}
