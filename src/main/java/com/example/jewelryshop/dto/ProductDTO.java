package com.example.jewelryshop.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;

    @NotBlank(message = "Ürün adı kesinlikle boş bırakılamaz!")
    private String name;

    @NotBlank(message = "Marka bilgisi boş bırakılamaz!")
    private String brand;

    @NotBlank(message = "Kategori bilgisi boş bırakılamaz!")
    private String category;

    @NotNull(message = "Fiyat bilgisi girilmek zorundadır!")
    @DecimalMin(value = "1.0", message = "Fiyat en az 1 TL olmalıdır!")
    private BigDecimal price;

    @NotNull(message = "Stok bilgisi girilmek zorundadır!")
    @PositiveOrZero(message = "Stok adedi eksi (-) olamaz!")
    private Integer stock;

    private String imageUrl;
}