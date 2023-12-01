package com.example.basic.basiccontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    
    public List<ProductEntity> selectProductFilter(
        @ModelAttribute ProductEntity product){
            return productService.selectProductFilter(product);
        }

    @PostMapping("/{productId}/{productName}/{productPrice}")
    public List<ProductDto> insertProduct(
        @ModelAttribute ProductDto product){
            return productService.insertProduct(product);
        }

}
