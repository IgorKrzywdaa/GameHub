# Dokumentacja REST API - GameHub

Adres bazowy: http://localhost:8080

API wykorzystuje format JSON do przesylania danych.

## 1. Zarzadzanie grami

Sciezka bazowa: /api/games

| Metoda | Endpoint | Opis |
|---|---|---|
| GET | /api/games | Pobieranie wszystkich gier |
| GET | /api/games/{id} | Pobieranie gry po ID |
| GET | /api/games/genre/{genre} | Wyszukiwanie gier wedlug gatunku |
| POST | /api/games | Dodawanie nowej gry |
| PUT | /api/games/{id} | Aktualizacja gry |
| DELETE | /api/games/{id} | Usuwanie gry |

### Dodawanie gry

Metoda: POST

Endpoint: /api/games

Przykladowe dane JSON:

    {
      "title": "Cyber Adventure",
      "genre": "RPG",
      "description": "Przykladowa gra",
      "releaseYear": 2027,
      "status": "IN_DEVELOPMENT",
      "developer": "GameHub Studio"
    }

Dostepne statusy gry:

- PLANNING
- IN_DEVELOPMENT
- BETA
- RELEASED
- ON_HOLD

### Aktualizacja gry

Metoda: PUT

Endpoint: /api/games/1

Wymaga przeslania danych gry w formacie JSON.

### Usuwanie gry

Metoda: DELETE

Endpoint: /api/games/1

## 2. Zarzadzanie pracownikami

Sciezka bazowa: /api/employees

| Metoda | Endpoint | Opis |
|---|---|---|
| GET | /api/employees | Pobieranie wszystkich pracownikow |
| GET | /api/employees/{id} | Pobieranie pracownika po ID |
| GET | /api/employees/email/{email} | Wyszukiwanie pracownika po e-mailu |
| POST | /api/employees | Dodawanie pracownika |
| PUT | /api/employees/{id} | Aktualizacja pracownika |
| DELETE | /api/employees/{id} | Usuwanie pracownika |

### Dodawanie pracownika

Metoda: POST

Endpoint: /api/employees

Przykladowe dane JSON:

    {
      "firstName": "Jan",
      "lastName": "Kowalski",
      "position": "Game Developer",
      "email": "jan.kowalski@example.com"
    }

### Aktualizacja pracownika

Metoda: PUT

Endpoint: /api/employees/1

Wymaga przeslania danych pracownika w formacie JSON.

### Usuwanie pracownika

Metoda: DELETE

Endpoint: /api/employees/1

## 3. Kody odpowiedzi HTTP

| Kod | Znaczenie |
|---|---|
| 200 | Operacja zakonczona sukcesem |
| 201 | Utworzono nowy rekord |
| 204 | Rekord zostal usuniety |
| 500 | Nieoczekiwany blad serwera |

## 4. Baza danych

Aplikacja korzysta z bazy H2 dzialajacej w pamieci operacyjnej. Dane sa zarzadzane przez Spring Data JPA.