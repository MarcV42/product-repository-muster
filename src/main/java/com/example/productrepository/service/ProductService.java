package com.example.productrepository.service;

import com.example.productrepository.models.NewProduct;
import com.example.productrepository.models.Product;
import com.example.productrepository.repository.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

// Random ID wird generiert und zu Product unter ziehen von newProduct hinzugefügt (hier & in ProductController Klasse)
    public Product addProduct(NewProduct newProduct) {
// hier wird neues Product zusammengesetzt
        Product product = new Product(
                UUID.randomUUID().toString(),
                newProduct.title(),
                newProduct.price()
        );

        return productRepository.save(product);
    }
}
