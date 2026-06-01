package com.example.jewelryshop.service.impl;

import com.example.jewelryshop.dto.ProductDTO;
import com.example.jewelryshop.entity.Product;
import com.example.jewelryshop.repository.ProductRepository;
import com.example.jewelryshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bu ID ile kayıtlı bir ürün bulunamadı!"));
        return convertToDTO(product);
    }


    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // İŞTE YENİ EKLENEN METODUMUZ BURADA! (7. Madde İçin)
    @Override
    public List<ProductDTO> getProductsByCategory(String category) {
        return productRepository.findByCategory(category)
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı!"));

        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setImageUrl(productDTO.getImageUrl());

        Product updatedProduct = productRepository.save(product);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }


    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setBrand(product.getBrand());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        dto.setImageUrl(product.getImageUrl());
        return dto;
    }

    private Product convertToEntity(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setCategory(dto.getCategory());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        product.setImageUrl(dto.getImageUrl());
        return product;
    }
}