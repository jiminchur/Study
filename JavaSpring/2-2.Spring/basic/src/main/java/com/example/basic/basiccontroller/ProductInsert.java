package com.example.basic.basiccontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.basic.model.entity.ProductDto;
import com.example.basic.model.service.ProductService;

@RestController
@RequestMapping("/ver1/insert")
public class ProductInsert {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/{productId}/{productName}/{productPrice}")
    public ResponseEntity<String> insertProduct(
        @RequestBody ProductDto product){
            return ResponseEntity.status(HttpStatus.CREATED).body("데이터가 성공적으로 추가되었습니다.");
        }
}
