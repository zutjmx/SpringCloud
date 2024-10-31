package com.zutjmx.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zutjmx.springcloud.msvc.products.entities.Product;
import com.zutjmx.springcloud.msvc.products.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
    
    //En lugar de usar @Autowired se declara el repositorio como final
    final private ProductRepository productRepository;

    //En lugar de usar @Autowired se inicializa el repositorio en el constructor
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {        
        return (List<Product>)productRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {        
        return productRepository.findById(id);
    }

}
