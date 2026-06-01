package com.example.jewelryshop.service;

import com.example.jewelryshop.dto.ProductDTO;
import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO getProductById(Long id);

    List<ProductDTO> getAllProducts();

    ProductDTO updateProduct(Long id, ProductDTO productDTO);

    void deleteProduct(Long id);

    // Kategoriye göre ürün getirme metodu (7. Madde İçin)
    List<ProductDTO> getProductsByCategory(String category);
}