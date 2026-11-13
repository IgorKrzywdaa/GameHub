# GameHub Backend

Backend projektu GameHub odpowiada za zarzadzanie danymi gier i pracownikow studia.

## Technologie

- Java 21
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Jakarta Persistence API
- H2 Database
- Maven
- JUnit 5
- Mockito

## Architektura

Aplikacja zostala podzielona na cztery podstawowe warstwy:

### Model
Zawiera klasy reprezentujace dane:
- Game
- Employee
- GameStatus

### Repository
Odpowiada za komunikacje z baza danych:
- GameRepository
- EmployeeRepository

### Service
Zawiera logike biznesowa:
- GameService
- EmployeeService

### Controller
Obsluguje zapytania HTTP:
- GameController
- EmployeeController

## REST API

### Gry - /api/games

| Metoda | Endpoint | Funkcja |
|---|---|---|
| GET | /api/games | Pobranie wszystkich gier |
| GET | /api/games/{id} | Pobranie gry po ID |
| GET | /api/games/genre/{genre} | Filtrowanie wedlug gatunku |
| POST | /api/games | Dodanie gry |
| PUT | /api/games/{id} | Aktualizacja gry |
| DELETE | /api/games/{id} | Usuniecie gry |

### Pracownicy - /api/employees

| Metoda | Endpoint | Funkcja |
|---|---|---|
| GET | /api/employees | Pobranie pracownikow |
| GET | /api/employees/{id} | Pobranie pracownika po ID |
| GET | /api/employees/email/{email} | Wyszukiwanie po e-mailu |
| POST | /api/employees | Dodanie pracownika |
| PUT | /api/employees/{id} | Aktualizacja pracownika |
| DELETE | /api/employees/{id} | Usuniecie pracownika |

## Baza danych

Projekt korzysta z H2 In-Memory Database.

Dane sa zarzadzane przez Spring Data JPA. Aktualnie baza dziala w pamieci operacyjnej, dlatego dane sa resetowane po restarcie aplikacji.

## Uruchomienie

Wymagany jest Java 21.

Uruchomienie testow:

    .\mvnw.cmd clean test

Uruchomienie aplikacji:

    .\mvnw.cmd spring-boot:run

Aplikacja dziala pod adresem http://localhost:8080.

## Testy

Testy jednostkowe GameService znajduja sie w:

src/test/java/com/gamehub/service/GameServiceTest.java

Testy wykorzystuja JUnit 5 i Mockito.