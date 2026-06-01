package com.example.jewelryshop.config;

import com.example.jewelryshop.entity.Product;
import com.example.jewelryshop.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(ProductRepository productRepository) {
        return args -> {
            // Eğer sistem boşsa tüm listeyi tek seferde yükle
            if (productRepository.findAll().isEmpty()) {

                // --- BENİM EKLENTİLERİM (İnternet Linkli Lüks Ürünler) ---
                Product urun1 = new Product();
                urun1.setName("18 Ayar Altın Pırlantalı Kolye");
                urun1.setBrand("Cartier");
                urun1.setCategory("Kadın Kolye"); // Kategorisi güncellendi
                urun1.setPrice(BigDecimal.valueOf(450000));
                urun1.setStock(3);
                urun1.setImageUrl("https://images.unsplash.com/photo-1599643478518-a784e5dc4c8f?w=400");

                Product urun2 = new Product();
                urun2.setName("Zümrüt Kesim Pırlanta Yüzük");
                urun2.setBrand("Tiffany & Co.");
                urun2.setCategory("Erkek Yüzük"); // Kategorisi güncellendi
                urun2.setPrice(BigDecimal.valueOf(850000));
                urun2.setStock(2);
                urun2.setImageUrl("https://images.unsplash.com/photo-1605100804763-247f67b3557e?w=400");

                Product urun3 = new Product();
                urun3.setName("Pırlanta Su Yolu Küpe");
                urun3.setBrand("Bvlgari");
                urun3.setCategory("Kadın Küpe"); // Kategorisi güncellendi
                urun3.setPrice(BigDecimal.valueOf(320000));
                urun3.setStock(5);
                urun3.setImageUrl("https://images.unsplash.com/photo-1535632066927-ab7c9ab60908?w=400");

                Product urun4 = new Product();
                urun4.setName("Vintage Alhambra Bileklik");
                urun4.setBrand("Van Cleef & Arpels");
                urun4.setCategory("Kadın Bileklik"); // Kategorisi güncellendi
                urun4.setPrice(BigDecimal.valueOf(275000));
                urun4.setStock(4);
                urun4.setImageUrl("https://images.unsplash.com/photo-1611591437281-460bfbe1220a?w=400");

                // --- SENİN EKLENTİLERİN (Kendi Yerel Fotoğrafların) ---
                Product urun5 = new Product();
                urun5.setName("Safir Taşı Zarif Kolye");
                urun5.setBrand("Edde Premium");
                urun5.setCategory("Kadın Kolye"); // Kategorisi güncellendi
                urun5.setPrice(BigDecimal.valueOf(14500));
                urun5.setStock(10);
                // HTML'deki klasöründen resmi çekiyor
                urun5.setImageUrl("images/foto1.webp");

                Product urun6 = new Product();
                urun6.setName("Parıltılı Kolye");
                urun6.setBrand("Edde Premium");
                urun6.setCategory("Kadın Kolye"); // Kategorisi güncellendi
                urun6.setPrice(BigDecimal.valueOf(3500));
                urun6.setStock(15);
                urun6.setImageUrl("images/foto2.jpeg");

                Product urun7 = new Product();
                urun7.setName("Pırlanta Yüzük");
                urun7.setBrand("Edde Premium");
                urun7.setCategory("Erkek Yüzük"); // Kategorisi güncellendi
                urun7.setPrice(BigDecimal.valueOf(5000));
                urun7.setStock(8);
                // Fotoğraf adını kendi klasöründeki yüzük fotoğrafına göre güncelleyebilirsin
                urun7.setImageUrl("images/foto3.jpg");

                // Hepsini veritabanına tek seferde kaydet
                productRepository.save(urun1);
                productRepository.save(urun2);
                productRepository.save(urun3);
                productRepository.save(urun4);
                productRepository.save(urun5);
                productRepository.save(urun6);
                productRepository.save(urun7);

                System.out.println("✨ Birleştirilmiş dev başlangıç paketi güncel kategorilerle yüklendi! ✨");
            }
        };
    }
}