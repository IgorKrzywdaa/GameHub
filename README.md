# GameHub

GameHub to projekt zespolowy dotyczacy zarzadzania informacjami o grach oraz pracownikach studia tworzacego gry.

## Technologie

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- H2 Database
- Maven

## Struktura projektu

- backend/ - aplikacja backendowa
- backend/src/main/java/ - kod zrodlowy
- backend/src/test/ - testy jednostkowe
- backend/data/ - przykladowe dane
- backend-design.md - dokumentacja architektury
- docs/ - dokumentacja API i bazy danych

## Funkcjonalnosci

- Zarzadzanie grami.
- Zarzadzanie pracownikami.
- Dodawanie, pobieranie, aktualizacja i usuwanie danych.
- Wyszukiwanie gier wedlug gatunku.
- Wyszukiwanie pracownikow wedlug adresu e-mail.
- Komunikacja poprzez REST API.

## Uruchomienie

Wymagania:
- Java 21
- Dostep do internetu podczas pobierania zaleznosci Maven.

Uruchomienie z katalogu glownego:

    cd backend
    .\mvnw.cmd clean test
    .\mvnw.cmd spring-boot:run

Aplikacja dostepna jest pod adresem:

http://localhost:8080

Konsola H2:

http://localhost:8080/h2-console

## Dokumentacja

- [Dokumentacja backendu](backend/README.md)
- [Architektura backendu](backend-design.md)
- [Dokumentacja REST API](docs/api.md)
- [Dokumentacja bazy danych](docs/database.md)

## Testowanie

Testy jednostkowe znajduja sie w katalogu:

backend/src/test/java/

Uruchomienie testow:

    cd backend
    .\mvnw.cmd clean test

## Baza danych

Projekt wykorzystuje H2 In-Memory Database. Dane sa przechowywane w pamieci i resetowane po ponownym uruchomieniu aplikacji.