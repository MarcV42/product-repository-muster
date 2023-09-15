package com.example.productrepository.controller;

import com.example.productrepository.models.NewProduct;
import com.example.productrepository.models.Product;
import com.example.productrepository.repository.ProductRepository;
import com.example.productrepository.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        System.out.println("Hier bin ich in Controller");
      return this.productService.findAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody NewProduct newProduct){
        return productService.addProduct(newProduct);
    }

}
