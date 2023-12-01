package com.example.basic.basiccontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.entity.ProductDto;
import com.example.basic.model.entity.ProductEntity;
import com.example.basic.model.service.ProductService;


@RestController
@RequestMapping("/ver1/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    
    @GetMapping("/insert/{ProductId}/{ProductName}/{ProductPrice}")
    public void insertProduct(@ModelAttribute ProductDto product){
        productService.insertProduct(product);
    }

    @GetMapping("/update/{ProductId}/{ProductName}/{ProductPrice}")
    public void updateProduct(@ModelAttribute ProductDto product){
        productService.updateProduct(product);
    }

    @GetMapping("/delete/{ProductId}")
    public void deleteProduct(@PathVariable("ProductId") int productId) {
        productService.deleteProduct(productId);
    }
}
