package com.example.productrepository.repository;

import com.example.productrepository.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//Connection zur Datenbank
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
