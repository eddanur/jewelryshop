package com.example.jewelryshop.controller;

import com.example.jewelryshop.dto.ProductDTO;
import com.example.jewelryshop.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/products")
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


    @GetMapping("/kategori/kolyeler")
    public List<ProductDTO> getKolyeler() {
        ProductDTO kolye = new ProductDTO();
        kolye.setId(1L); // L harfi geri geldi
        kolye.setName("18 Ayar Altın Pırlantalı Kolye");
        kolye.setBrand("Cartier");
        kolye.setCategory("Kolye");
        kolye.setPrice(BigDecimal.valueOf(450000)); //
        kolye.setStock(3);
        kolye.setImageUrl("https://ornekresim.com/cartier-kolye.jpg");

        return List.of(kolye);
    }


    @GetMapping("/kategori/yuzukler")
    public List<ProductDTO> getYuzukler() {
        ProductDTO yuzuk = new ProductDTO();
        yuzuk.setId(2L);
        yuzuk.setName("Zümrüt Kesim Pırlanta Yüzük");
        yuzuk.setBrand("Tiffany & Co.");
        yuzuk.setCategory("Yüzük");
        yuzuk.setPrice(BigDecimal.valueOf(850000));
        yuzuk.setStock(2);
        yuzuk.setImageUrl("https://ornekresim.com/tiffany-yuzuk.jpg");

        return List.of(yuzuk);
    }


    @GetMapping("/kategori/kupeler")
    public List<ProductDTO> getKupeler() {
        ProductDTO kupe = new ProductDTO();
        kupe.setId(3L);
        kupe.setName("Pırlanta Su Yolu Küpe");
        kupe.setBrand("Bvlgari");
        kupe.setCategory("Küpe");
        kupe.setPrice(BigDecimal.valueOf(320000));
        kupe.setStock(5);
        kupe.setImageUrl("https://ornekresim.com/bvlgari-kupe.jpg");

        return List.of(kupe);
    }


    @GetMapping("/kategori/bileklikler")
    public List<ProductDTO> getBileklikler() {
        ProductDTO bileklik = new ProductDTO();
        bileklik.setId(4L);
        bileklik.setName("Vintage Alhambra Bileklik");
        bileklik.setBrand("Van Cleef & Arpels");
        bileklik.setCategory("Bileklik");
        bileklik.setPrice(BigDecimal.valueOf(275000));
        bileklik.setStock(4);
        bileklik.setImageUrl("https://ornekresim.com/vancleef-bileklik.jpg");

        return List.of(bileklik);
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