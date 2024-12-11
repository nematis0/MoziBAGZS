# BAGZS

A BAGZS project egy Java és Spring Boot alapú webalkalmazás, amely lehetővé teszi a felhasználók számára, hogy böngésszék az elérhető filmeket és lefoglalják az általuk választott vetítésekre a helyeket.

# Tartalomjegyzék
- Technológiák
- Funkciók
- Első lépések
    - Előkövetelmények
    - Telepítés
- Használat
- Hozzájárulás
- Licenc

# Technológiák

- **Java**: Az alkalmazás elsődleges backend nyelve.
- **Spring Boot**: Egy erőteljes keretrendszer Java-alapú alkalmazások fejlesztéséhez.
- **Spring Data JPA**: Egyszerű integrációt biztosít a JPA-val (Java Persistence API) az adatok eléréséhez.
- **Hibernate**: Egy további ORM (Objektum-Relációs Leképezés) keretrendszer, amely együtt használható a Spring Data JPA-val az adatbázis kezelésére és kezelésére.
- **Thymeleaf**: Egy modern szerveroldali Java sablonmotor HTML sablonok rendereléséhez.
- **HTML és CSS**: Interaktív felhasználói felületek létrehozására szolgáló frontend technológiák.
- **Bootstrap**: Népszerű CSS-keretrendszer, amely egyszerűbbé teszi a reszponzív és vizuálisan vonzó weboldalak elkészítését.
- **REST API**: Webszolgáltatások fejlesztésére szolgáló szoftver architektúra, amely Spring Boot segítségével valósítható meg.
- **MySQL adatbázis**: Nyílt forráskódú relációs adatbázis-kezelő rendszer az alkalmazás adatok tárolásához és kezeléséhez.

# Funkciók

- **Filmek böngészése**: A felhasználók megtekinthetik az elérhető filmek listáját.
- **Helyfoglalás**: Interaktív helyfoglalási felület, amely lehetővé teszi a felhasználók számára a helyek kiválasztását.
- **Foglaláskezelés**: Hatékony foglaláskezelési rendszer moziadminisztrátorok számára.
- **Felhasználói hitelesítés**: Biztonságos felhasználói hitelesítés és munkamenet-kezelés.

# Első lépések

## Előkövetelmények
Győződj meg róla, hogy az alábbi eszközök telepítve vannak:

- **Java fejlesztőkészlet (JDK)**
- **Maven build eszköz**
- **IDE, például Eclipse, IntelliJ vagy Spring Boot IDE**
- **MySQL adatbázis szerver**

## Telepítés

1. **Klónozás**:
   ```bash
   git clone <repository-url>
   ```

2. **Adatbázis beállítása**:
    - Hozz létre egy MySQL adatbázist, és frissítsd az `application.properties` fájlt a `src/main/resources` könyvtárban az adatbázis hitelesítési adataival:
      ```properties
      spring.datasource.url=jdbc:mysql://<adatbázis-host>:<port>/<adatbázis-név>
      spring.datasource.username=<felhasználónév>
      spring.datasource.password=<jelszó>
      ```

3. **IDE konfiguráció**:
    - Importáld a projektet az általad preferált IDE-be (Eclipse, IntelliJ vagy Spring Boot IDE).

4. **Fordítás és futtatás**:
    - Fordítsd le és futtasd az alkalmazást az IDE-ből, vagy használd a Maven/Gradle parancssort:
      ```bash
      mvn spring-boot:run
      ```
      vagy
      ```bash
      gradle bootRun
      ```

# Használat

Az alkalmazás futtatásához nyisd meg a `http://localhost:8080` linket egy böngészőablakban. Kövesd a képernyőn megjelenő utasításokat a kívánt film kiválasztásához és a helyfoglaláshoz.

