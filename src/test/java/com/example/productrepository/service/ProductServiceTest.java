package com.example.productrepository.service;

import com.example.productrepository.models.NewProduct;
import com.example.productrepository.models.Product;
import com.example.productrepository.repository.ProductRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class ProductServiceTest {

    ProductRepository productRepository = mock(ProductRepository.class);
    IdService idService = mock(IdService.class);
    ProductService productService = new ProductService(productRepository, idService);

    //is working
    @Test
    void findAllProducts() {
        //GIVEN
        Product p1 = new Product("1", "product1", 2);
        List<Product> productList = List.of(p1);

        when(productRepository.findAll()).thenReturn(productList);

        //WHEN
        List<Product> actual = productService.findAllProducts();

        //THEN
        List<Product> expected = List.of(new Product("1", "product1", 2));

        verify(productRepository).findAll();
        assertEquals(expected, actual);
    }


    //is working
    @Test
    void addProduct() {
        //GIVEN

        NewProduct newProduct = new NewProduct("product1", 30);
        Product savedProduct = new Product("123", "product1", 30);

        when(idService.randomId()).thenReturn("123");
        when(productRepository.save(any(Product.class))).thenReturn(savedProduct);

        //WHEN
        Product actual = productService.addProduct(newProduct);

        //THEN
        Product expected = new Product("123", "product1", 30);
        verify(productRepository).save(argThat(product ->
                product.title().equals("product1") && product.price() == 30));
        assertEquals(expected, actual);
    }

    @Test
    void testFindAllProducts() {
    }


    //is working
    @Test
    void findProductById() {

            //GIVEN
            Product p1 = new Product("5", "Banane", 50);

            String id = p1.id();

            when(productRepository.findById(id)).thenReturn(Optional.of(p1));

            //WHEN
            Optional<Product> actual = productService.findProductById("5");

            //THEN
            Optional<Product> expected = Optional.of(new Product("5", "Banane", 50));
            verify(productRepository).findById("5");
            assertEquals(expected,actual);

        }
}
