package com.example.productrepository.service;

import com.example.productrepository.models.NewProduct;
import com.example.productrepository.models.Product;
import com.example.productrepository.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final IdService idService; // IdService hinzufügen

    public ProductService(ProductRepository productRepository, IdService idService) {
        this.productRepository = productRepository;
        this.idService = idService;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

// Random ID wird generiert und zu Product unter ziehen von newProduct hinzugefügt (hier & in ProductController Klasse)
    public Product addProduct(NewProduct newProduct) {
// hier wird neues Product zusammengesetzt

        String randomId = idService.randomId();
        // Erstellen Sie ein neues Produkt mit der generierten ID
        Product product = new Product(
                idService.randomId(),
                newProduct.title(),
                newProduct.price()
        );

        return productRepository.save(product);
    }

/*
 public Product addProduct(NewProduct newProduct) {
// hier wird neues Product zusammengesetzt
        Product product = new Product(
                UUID.randomUUID().toString(),
                newProduct.title(),
                newProduct.price()
        );

        return productRepository.save(product);
    }
 */

    public Optional<Product> findProductById(String id) {
        return productRepository.findById(id);
            }

/*
    public void removeProduct(String id) {
        for (Product product : product) {
            if (product.id().equals(id)) {
                product.remove(product);
                return;
            }
        }
*/
    }