#  Jewelry Shop REST API

Bu proje, Spring Boot kullanılarak geliştirilmiş bir Takı/Mücevher Dükkanı (Jewelry Shop) ürün yönetim sistemidir. RESTful API standartlarına uygun olarak tasarlanmış olup, temel CRUD işlemlerini ve Rol Bazlı Yetkilendirme (Spring Security) özelliklerini barındırmaktadır.

##  Kullanılan Teknolojiler
* Java
* Spring Boot
* Spring Data JPA
* Spring Web (REST API)
* Spring Security (Role-Based Access Control)

##  Proje Yapısı (Katmanlar)
Proje, N-Tier (Çok Katmanlı) bir şekilde ele alınmıştır :
* **Entity:** Veritabanı tablolarının nesne karşılıkları (Product).
* **Repository:** Veritabanı işlemleri ve Özel Sorgular (Derived Queries: `findByCategory`, `findByPriceLessThan`).
* **DTO (Data Transfer Object):** İstemci ile sunucu arasındaki güvenli veri taşıma objeleri.
* **Service:** İş kuralları ve mantığı (Business Logic).
* **Controller:** Dış dünyaya açılan API uçları.
* **Exception Handling:** `@ControllerAdvice` ve `GlobalExceptionHandler` ile global, kullanıcı dostu hata yönetimi.

##  Güvenlik (Spring Security) ve API Uçları
Sistemde güvenlik katmanı aktif edilmiş olup, rol bazlı yetkilendirme (RBAC) uygulanmıştır:

| HTTP Metodu | Endpoint | Açıklama | Yetki |
| :--- | :--- | :--- | :--- |
| GET | `/api/products` | Tüm ürünleri listeler | Herkes (PermitAll) |
| GET | `/api/products/{id}` | ID'ye göre tek bir ürün getirir | Herkes (PermitAll) |
| POST | `/api/products` | Yeni ürün ekler | Sadece ADMIN |
| PUT | `/api/products/{id}` | Mevcut ürünü günceller | Sadece ADMIN |
| DELETE | `/api/products/{id}` | Ürünü siler | Sadece ADMIN |

**Test İçin Hazırlanan Kullanıcılar:**
* **Admin Yetkili:** Kullanıcı Adı: `admin` | Şifre: `admin123`
* **Normal Kullanıcı:** Kullanıcı Adı: `musteri` | Şifre: `musteri123`

---
*Geliştirici: [Edanur Dede]*