package com.example.basic.model.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.basic.model.entity.ProductDto;
import com.example.basic.model.entity.ProductEntity;

@Mapper
public interface ProductMapper {
    List<ProductEntity> selectProductFilter(
        @Param("productId") int productId,
        @Param("productName") String productName,
        @Param("productPrice") int productPrice
    );
    
    List<ProductDto> insertProduct(
        @Param("productId") int productId,
        @Param("productName") String productName,
        @Param("productPrice") int productPrice
    );
} 
