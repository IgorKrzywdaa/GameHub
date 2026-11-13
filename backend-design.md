# Projekt architektury backendu - GameHub

## 1. Cel

Celem backendu GameHub jest zapewnienie warstwy odpowiedzialnej za przetwarzanie danych, logike biznesowa oraz komunikacje z frontendem aplikacji.

Backend udostepnia interfejs REST API umozliwiajacy zarzadzanie grami oraz pracownikami studia.

## 2. Wykorzystane technologie

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Jakarta Persistence API
- H2 Database
- Maven

## 3. Architektura aplikacji

Aplikacja wykorzystuje architekture warstwowa.

### 3.1 Model

Warstwa modelu reprezentuje dane wykorzystywane przez aplikacje.

Game:
- id
- title
- genre
- description
- releaseYear
- status
- developer

Employee:
- id
- firstName
- lastName
- position
- email

GameStatus:
- PLANNING
- IN_DEVELOPMENT
- BETA
- RELEASED
- ON_HOLD

### 3.2 Repository

Warstwa Repository odpowiada za dostep do danych.

W projekcie wykorzystano:
- GameRepository
- EmployeeRepository

Repozytoria rozszerzaja JpaRepository, co zapewnia podstawowe operacje CRUD oraz mozliwosc tworzenia zapytan na podstawie nazw metod.

### 3.3 Service

Warstwa Service zawiera logike biznesowa.

GameService odpowiada za:
- pobieranie wszystkich gier,
- pobieranie gry wedlug ID,
- filtrowanie gier wedlug gatunku,
- dodawanie gier,
- aktualizowanie gier,
- usuwanie gier.

EmployeeService odpowiada za:
- pobieranie pracownikow,
- wyszukiwanie pracownika wedlug ID,
- wyszukiwanie pracownika wedlug adresu e-mail,
- dodawanie pracownikow,
- aktualizowanie pracownikow,
- usuwanie pracownikow.

### 3.4 Controller

Warstwa Controller udostepnia funkcjonalnosci poprzez REST API.

GameController obsluguje endpointy /api/games.

EmployeeController obsluguje endpointy /api/employees.

Kontrolery wykorzystuja metody HTTP GET, POST, PUT i DELETE.

## 4. Baza danych

Do przechowywania danych wykorzystano H2 Database.

Dostep do bazy realizowany jest za pomoca Spring Data JPA.

Dane sa mapowane na tabele za pomoca Jakarta Persistence API.

Aktualna konfiguracja wykorzystuje baze In-Memory, ktorej zawartosc jest resetowana po ponownym uruchomieniu aplikacji.

## 5. Komunikacja z frontendem

Frontend komunikuje sie z backendem za pomoca zapytan HTTP.

Dane przesylane sa w formacie JSON.

Podstawowy adres API:

http://localhost:8080

Glowne zasoby:
- /api/games
- /api/employees

## 6. Obsluga bledow

Serwisy zglaszaja wyjatek RuntimeException w przypadku nieodnalezienia rekordu.

Kontrolery zwracaja odpowiedzi HTTP za pomoca ResponseEntity.

## 7. Testowanie

Logika GameService jest sprawdzana za pomoca testow jednostkowych.

Wykorzystane narzedzia:
- JUnit 5
- Mockito

Testy obejmuja pobieranie, dodawanie, aktualizowanie, usuwanie i wyszukiwanie gier.

## 8. Mozliwosci dalszego rozwoju

- Zastosowanie trwalej bazy danych, np. PostgreSQL.
- Rozbudowa walidacji danych wejsciowych.
- Wprowadzenie centralnej obslugi wyjatkow.
- Dodanie autoryzacji i uwierzytelniania uzytkownikow.
- Rozbudowa testow integracyjnych.
- Integracja z frontendem GameHub.