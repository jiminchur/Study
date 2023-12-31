package com.example.basic.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.basic.model.entity.ProductDto;
import com.example.basic.model.entity.ProductEntity;
import com.example.basic.model.repository.ProductMapper;

@Service
public class ProductService {
    
    @Autowired
    private ProductMapper productMapper;

    public List<ProductEntity> selectProductFilter(ProductEntity product){
        List<ProductEntity> productList = productMapper.selectProductFilter(
            product.getProductId(), product.getProductName(), product.getProductPrice()
        );
        return productList ;
    }
    public void insertProduct(ProductDto dto) {
        if(dto.getProductName() != null) {
        productMapper.insertProduct(dto);
        }

        productMapper.insertProduct(dto);
    }

    public void updateProduct(ProductDto dto) {
        if(dto.getProductId() != 0) {
            productMapper.updateProduct(dto);
        }
    }

    public void deleteProduct(int productId) {
        if(productId != 0) {
            productMapper.deleteProduct(productId);
        }
    }
    
}
