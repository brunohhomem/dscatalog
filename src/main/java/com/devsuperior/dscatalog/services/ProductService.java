package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.ProductDTO;
import com.devsuperior.dscatalog.entities.Product;
import com.devsuperior.dscatalog.repositories.ProductRepository;
import com.devsuperior.dscatalog.services.exceptions.DatabaseException;
import com.devsuperior.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service //registra a classe como um componente de injeção de dependencia
public class ProductService {
    @Autowired private ProductRepository productRepository;

//    @Transactional(readOnly = true)
//    public List<ProductDTO> findAll(){
//        List<Product> list = productRepository.findAll();
//        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
//    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAllPaged(PageRequest pageRequest) {
        Page<Product> list = productRepository.findAll(pageRequest);
        return list.map(x -> new ProductDTO(x));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada."));
        return new ProductDTO(entity, entity.getCategories());
    }
//    @Transactional
//    public ProductDTO insert(ProductDTO dto) {
//        Product entity = new Product();
//        entity.setName(dto.getName());
//        entity = productRepository.save(entity);
//        return new ProductDTO(entity);
//    }
//    @Transactional
//    public ProductDTO update(Long id, ProductDTO dto) {
//        try {
//            Product entity = productRepository.getReferenceById(id);
//            entity.setName(dto.getName());
//            entity = productRepository.save(entity);
//            return new ProductDTO(entity);
//        }
//        catch (EntityNotFoundException e){
//            throw new ResourceNotFoundException("Id not found: " + id);
//        }
//    }
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id not found: " + id);
        }
        catch (DataIntegrityViolationException e){
           throw new DatabaseException("Integrity violation");
       }
    }
}
