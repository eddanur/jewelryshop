<img width="1897" height="902" alt="Ekran görüntüsü 2026-10-05 221642" src="https://github.com/user-attachments/assets/ba3cd1e5-7c63-436a-9a7e-7b5ee7b08f6f" />💎 EDDE JEWELRY - E-Ticaret ve REST API Yönetim Sistemi

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
* **Gelişmiş Sepet ve Teslimat Yönetimi:** `localStorage` tabanlı çalışan, 81 il entegreli dinamik teslimat formu ve anlık fiyat hesaplama özelliği.
* **Sipariş Takip ve Dinamik İptal Sistemi:** Müşterilerin geçmiş siparişlerini adres bilgileriyle görüntüleyebildiği, ister tek bir ürünü ister tüm siparişi iptal edip toplam tutarın anında güncellendiği `siparislerim.html` modülü.
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
   * <img width="1897" height="907" alt="Ekran görüntüsü 2026-10-05 221336" src="https://github.com/user-attachments/assets/61de5959-9a8a-4fc1-a9a9-f86ddd822131" />
<img width="1897" height="902" alt="Ekran görüntüsü 2026-10-05 221642" src="https://github.com/user-attachments/assets/1d1796e4-2318-4ef4-a09a-576cbd637bc7" />
<img width="1900" height="902" alt="Ekran görüntüsü 2026-10-05 221826" src="https://github.com/user-attachments/assets/ca9ec282-1498-4246-8e19-9b9db3d28f43" />
<img width="1917" height="872" alt="Ekran görüntüsü 2026-10-05 221318" src="https://github.com/user-attachments/assets/cd4d0d7a-bffa-4626-bca6-02cd0dd5d9cd" />


---
*Geliştirici: [Edanur Dede]*
