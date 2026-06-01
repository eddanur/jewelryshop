💎 EDDE JEWELRY - E-Ticaret ve REST API Yönetim Sistemi

Bu proje, Spring Boot kullanılarak geliştirilmiş güçlü bir RESTful API arka planına ve HTML/CSS/JS ile kodlanmış, tamamen dinamik çalışan estetik bir ön yüze (Frontend) sahip Takı/Mücevher Dükkanı yönetim sistemidir.

Temel CRUD işlemlerini, Rol Bazlı Yetkilendirmeyi (Spring Security) ve API ile anlık haberleşen akıllı arama/filtreleme özelliklerini barındırmaktadır.

##  Kullanılan Teknolojiler
**Backend (Arka Plan):**
* Java
* Spring Boot
* Spring Data JPA (Hibernate)
* Spring Web (REST API)
* Spring Security (Role-Based Access Control)
* Veri Doğrulama (Validation)

**Frontend (Ön Yüz):**
* HTML5, CSS3, Vanilla JavaScript
* Fetch API (Asenkron Veri Çekimi)
* Responsive ve Minimalist "Avant-Garde" Tasarım

## Proje Yapısı ve Katmanlar (N-Tier Architecture)
Proje, N-Tier (Çok Katmanlı) mimari prensiplerine uygun olarak geliştirilmiştir:
* **Entity:** Veritabanı tablolarının nesne karşılıkları (`Product`). Özellikle görsel linkleri için özel boyutlandırmalar (`@Column(length = 2000)`) içerir.
* **Repository:** Veritabanı işlemleri ve Özel Sorgular (Derived Queries: `findByCategory`, `findByPriceLessThan`).
* **DTO (Data Transfer Object):** İstemci ile sunucu arasındaki güvenli veri taşıma objeleri.
* **Service:** İş kuralları ve mantığı (Business Logic).
* **Controller:** Dış dünyaya açılan API uçları.
* **Exception Handling:** `@ControllerAdvice` ve `GlobalExceptionHandler` ile global, kullanıcı dostu hata yönetimi.

##  Öne Çıkan Frontend & Backend Entegrasyonları
* **Dinamik Yönetim Paneli (Admin):** Yetkisiz erişime kapalı, şifreli giriş sistemi. Sayfa yenilenmeden çalışan ürün ekleme, silme, güncelleme (form otomatik doldurma) ve anlık çalışan **"Akıllı Tablo Arama"** özelliği.
* **Gelişmiş Arama Motoru:** Kategoriye veya ürün ismine göre tüm veritabanını tarayan, URL parametreleriyle entegre çalışan arama sayfası (`arama.html`).
* **Akıllı Vitrin ve UI Detayları:** Sınırlı sayıda (16 ürün) vitrin listelemesi, estetik 3'lü yatay slider ve thumbnail yapısı, dinamik "Benzer Ürünler" algoritması.

##  Güvenlik (Spring Security) ve API Uçları
Sistemde güvenlik katmanı aktif edilmiş olup, rol bazlı yetkilendirme (RBAC) uygulanmıştır:

| HTTP Metodu | Endpoint | Açıklama | Yetki |
| :--- | :--- | :--- | :--- |
| **GET** | `/api/products` | Tüm ürünleri listeler | Herkes (PermitAll) |
| **GET** | `/api/products/{id}` | ID'ye göre tek bir ürün getirir | Herkes (PermitAll) |
| **POST** | `/api/products` | Yeni ürün ekler | Sadece ADMIN |
| **PUT** | `/api/products/{id}` | Mevcut ürünü günceller | Sadece ADMIN |
| **DELETE** | `/api/products/{id}` | Ürünü siler | Sadece ADMIN |

**Test İçin Hazırlanan Kullanıcılar:**
* **Admin Yetkili:** Kullanıcı Adı: `admin` | Şifre: `admin123`
* **Normal Kullanıcı:** Kullanıcı Adı: `musteri` | Şifre: `musteri123`
* ## ⚙️ Kurulum ve Çalıştırma (Nasıl Kullanılır?)

Bu projeyi kendi bilgisayarınızda çalıştırmak için aşağıdaki adımları izleyebilirsiniz:

1. **Projeyi Klonlayın:**
   `git clone https://github.com/eddanur/jewelryshop.git`
2. **Backend (Spring Boot) Çalıştırma:**
   * Projeyi IntelliJ IDEA veya Eclipse gibi bir IDE ile açın.
   * Maven bağımlılıklarının (dependencies) inmesini bekleyin.
   * `JewelryshopApplication.java` dosyasını bularak projeyi `Run` (Başlat) seçeneğiyle çalıştırın.
   * Sunucu varsayılan olarak `http://localhost:8080` portunda ayağa kalkacaktır. (Veritabanı olarak in-memory H2 Database kullanıldığı için ekstra bir veritabanı kurulumuna gerek yoktur).
3. **Frontend (Ön Yüz) Çalıştırma:**
   * Proje dizinindeki `Shopify` klasörünü açın.
   * `index.html` dosyasına çift tıklayarak veya bir Live Server eklentisi kullanarak tarayıcıda açın.
   * Sağ üstteki dişli (⚙️) ikonuna tıklayarak Admin paneline erişebilir (`admin` / `admin123` şifresiyle) sistemi test edebilirsiniz.

---
*Geliştirici: [Edanur Dede]*
