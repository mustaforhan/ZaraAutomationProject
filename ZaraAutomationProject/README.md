# Zara UI Test Automation Project

Bu proje, www.zara.com/tr/ web sitesine yönelik uçtan uca bir otomasyon test senaryosunu kapsamaktadır. Proje Java, Maven, Selenium WebDriver, JUnit, Log4j ve Apache POI kütüphaneleri ile geliştirilmiştir.

##  Kullanılan Teknolojiler
- Java
- Maven
- Selenium WebDriver
- JUnit 4
- Log4j
- Apache POI
- Page Object Model (POM)
- Object-Oriented Programming (OOP)

## Proje Yapısı
- `data/input.xlsx` : Aranacak ürün isimleri (şort, gömlek)
- `data/output.txt` : Seçilen ürün adı ve fiyat bilgisi
- `logs/automation.log` : Log4j ile oluşturulan log dosyası
- `drivers/chromedriver.exe` : WebDriver için gerekli dosya (elle eklenmelidir)

## Test Senaryosu
1. Zara sitesi açılır
2. Kullanıcı login olur
3. Menü → ERKEK → Tümünü Gör tıklanır
4. Excel'den "şort" ve "gömlek" kelimeleri sırayla aranır
5. Ürünler listelenir, rastgele bir ürün seçilir
6. Ürün bilgisi `output.txt` dosyasına yazılır
7. Ürün sepete eklenir, fiyat doğrulanır
8. Ürün adedi artırılır, doğrulama yapılır
9. Ürün silinir, sepet boşluğu doğrulanır

## Kurulum ve Çalıştırma
- Java 8+ ve Maven kurulu olmalıdır
- `drivers/` klasörüne sisteminize uygun chromedriver eklenmelidir
- Aşağıdaki komutla test çalıştırılır:

```bash
mvn test
```

## Hazırlayan
Mustafa ORHAN
