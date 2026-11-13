# Dokumentacja bazy danych - GameHub

## 1. Informacje ogolne

Projekt GameHub wykorzystuje baze danych H2 oraz technologie Spring Data JPA do zarzadzania danymi.

Aktualna konfiguracja wykorzystuje baze dzialajaca w pamieci operacyjnej (In-Memory).

Dane sa przechowywane podczas dzialania aplikacji i resetowane po jej ponownym uruchomieniu.

## 2. Tabela games

Tabela przechowuje informacje o grach zarzadzanych przez system.

| Kolumna | Typ | Opis |
|---|---|---|
| id | BIGINT | Unikalny identyfikator gry |
| title | VARCHAR | Tytul gry |
| genre | VARCHAR | Gatunek gry |
| description | VARCHAR(2000) | Opis gry |
| release_year | INTEGER | Rok wydania |
| status | VARCHAR | Aktualny status gry |
| developer | VARCHAR | Nazwa producenta |

Identyfikator jest generowany automatycznie.

Dostepne statusy gry:

- PLANNING
- IN_DEVELOPMENT
- BETA
- RELEASED
- ON_HOLD

## 3. Tabela employees

Tabela przechowuje informacje o pracownikach studia.

| Kolumna | Typ | Opis |
|---|---|---|
| id | BIGINT | Unikalny identyfikator pracownika |
| first_name | VARCHAR | Imie pracownika |
| last_name | VARCHAR | Nazwisko pracownika |
| position | VARCHAR | Stanowisko |
| email | VARCHAR | Adres e-mail |

Identyfikator jest generowany automatycznie.

## 4. Mapowanie obiektowo-relacyjne

Mapowanie danych realizowane jest za pomoca Jakarta Persistence API (JPA).

Najwazniejsze adnotacje:

- @Entity - oznacza klase jako encje bazy danych.
- @Table - okresla nazwe tabeli.
- @Id - oznacza klucz glowny.
- @GeneratedValue - odpowiada za automatyczne generowanie identyfikatora.
- @Column - definiuje wlasciwosci kolumny.
- @Enumerated - okresla sposob zapisu wartosci wyliczeniowych.

## 5. Dostep do danych

Komunikacja z baza danych odbywa sie przez repozytoria:

- GameRepository - obsluga danych gier.
- EmployeeRepository - obsluga danych pracownikow.

Oba repozytoria wykorzystuja Spring Data JPA i interfejs JpaRepository.

## 6. Konfiguracja

Podstawowe ustawienia bazy danych znajduja sie w pliku:

backend/src/main/resources/application.properties

Aktualna baza danych:

H2 In-Memory Database.