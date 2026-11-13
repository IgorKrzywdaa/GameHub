package com.gamehub.service;

import com.gamehub.model.Game;
import com.gamehub.model.GameStatus;
import com.gamehub.repository.GameRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameService gameService;

    private Game sampleGame;

    @BeforeEach
    void setUp() {
        sampleGame = new Game(
                1L,
                "Cyber Adventure",
                "RPG",
                "Przykladowa gra",
                2027,
                GameStatus.IN_DEVELOPMENT,
                "GameHub Studio"
        );
    }

    @Test
    void shouldReturnAllGames() {
        when(gameRepository.findAll()).thenReturn(List.of(sampleGame));

        List<Game> games = gameService.getAllGames();

        assertEquals(1, games.size());
        assertEquals("Cyber Adventure", games.get(0).getTitle());
    }

    @Test
    void shouldReturnGameById() {
        when(gameRepository.findById(1L)).thenReturn(Optional.of(sampleGame));

        Game result = gameService.getGameById(1L);

        assertEquals("Cyber Adventure", result.getTitle());
        verify(gameRepository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenGameDoesNotExist() {
        when(gameRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class,
                () -> gameService.getGameById(99L));
    }

    @Test
    void shouldAddGame() {
        when(gameRepository.save(any(Game.class))).thenReturn(sampleGame);

        Game result = gameService.addGame(sampleGame);

        assertNotNull(result);
        assertEquals("Cyber Adventure", result.getTitle());
        verify(gameRepository).save(sampleGame);
    }

    @Test
    void shouldUpdateGame() {
        Game updatedGame = new Game(
                null,
                "New Adventure",
                "Action",
                "Updated description",
                2028,
                GameStatus.BETA,
                "New Studio"
        );

        when(gameRepository.findById(1L)).thenReturn(Optional.of(sampleGame));
        when(gameRepository.save(any(Game.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Game result = gameService.updateGame(1L, updatedGame);

        assertEquals("New Adventure", result.getTitle());
        assertEquals("Action", result.getGenre());
        assertEquals(2028, result.getReleaseYear());
        assertEquals(GameStatus.BETA, result.getStatus());
        verify(gameRepository).save(sampleGame);
    }

    @Test
    void shouldDeleteGame() {
        when(gameRepository.findById(1L)).thenReturn(Optional.of(sampleGame));

        gameService.deleteGame(1L);

        verify(gameRepository).delete(sampleGame);
    }

    @Test
    void shouldReturnGamesByGenre() {
        when(gameRepository.findByGenreIgnoreCase("RPG"))
                .thenReturn(List.of(sampleGame));

        List<Game> games = gameService.getGamesByGenre("RPG");

        assertEquals(1, games.size());
        assertEquals("RPG", games.get(0).getGenre());
    }
}