package com.example.jewelryshop.controller;

import com.example.jewelryshop.dto.ProductDTO;
import com.example.jewelryshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin // İşte web sitemize veri çekme izni veren sihirli anahtarımız!
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    // İŞTE BURASI! Tüm sahte veriler gitti, yerine tek ve dinamik metodumuz geldi (7. Madde)
    @GetMapping("/kategori/{categoryName}")
    public List<ProductDTO> getProductsByCategory(@PathVariable String categoryName) {
        return productService.getProductsByCategory(categoryName);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}