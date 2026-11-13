# GameHub

GameHub to projekt zespolowy poswiecony zarzadzaniu informacjami o grach oraz pracownikach studia tworzacego gry.

## Struktura projektu

- backend/ - aplikacja backendowa oparta na Spring Boot
- backend/src/main/java/ - kod zrodlowy aplikacji
- backend/data/ - przykladowe dane
- backend-design.md - dokumentacja architektury backendu
- docs/ - dokumentacja projektu

## Wykorzystane technologie

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Maven

## Funkcjonalnosci backendu

- Zarzadzanie grami
- Wyszukiwanie gier wedlug ID i gatunku
- Zarzadzanie pracownikami
- Wyszukiwanie pracownikow wedlug adresu e-mail
- Dodawanie, edytowanie i usuwanie rekordow

## Uruchomienie backendu

Wymagania:
- Java 21
- Dostep do internetu

W terminalu:

    cd backend
    .\mvnw.cmd clean test
    .\mvnw.cmd spring-boot:run

Aplikacja dziala pod adresem http://localhost:8080

Konsola H2: http://localhost:8080/h2-console

## Baza danych

Projekt korzysta z bazy H2 dzialajacej w pamieci operacyjnej. Dane sa resetowane po ponownym uruchomieniu aplikacji.

## Architektura backendu

Aplikacja wykorzystuje podzial na warstwy:

- Model - reprezentacja danych
- Repository - komunikacja z baza danych
- Service - logika biznesowa
- Controller - obsluga zadan HTTP