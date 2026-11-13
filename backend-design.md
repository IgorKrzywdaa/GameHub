# GameHub Team - Backend Design

## 1. Project Overview

The backend is responsible for managing information about games developed by GameHub Team.

Its main purpose is to organize game data, support internal company operations and provide a foundation for future application development.

## 2. Backend Architecture

The backend is divided into four logical layers.

### Model
Contains classes representing the main data structures:
- Game
- Employee
- GameStatus

### Controller
Responsible for handling requests and exposing backend functionality.

Example:
- GameController

### Service
Contains business logic and operations performed on application data.

Examples:
- GameService
- EmployeeService

### Repository
Responsible for organizing data access and storage operations.

Example:
- GameRepository

## 3. Game Data Structure

Each game contains:
- id - unique game identifier
- title - game title
- genre - game genre
- description - game description
- releaseYear - planned release year
- status - production status
- developer - responsible development team

## 4. Main Functionalities

- Adding new games.
- Retrieving game information.
- Updating game records.
- Removing games.
- Filtering games by genre.
- Managing production statuses.
- Managing employee information.

## 5. Data Management

Game information is represented using structured objects.

JSON is used as an example format for exchanging and presenting game data.

The repository layer separates data access from business logic.

## 6. Future Development

Possible improvements include:
- REST API implementation.
- Relational database integration.
- User authentication and authorization.
- Frontend integration.
- Advanced game filtering and searching.

## 7. Summary

The proposed architecture separates data models, business logic, data access and request handling.

This structure makes the backend easier to maintain, extend and integrate with other parts of the GameHub Team platform.
