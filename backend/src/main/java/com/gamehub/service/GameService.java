package com.gamehub.service;

import com.gamehub.model.Game;
import com.gamehub.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found: " + id));
    }

    public List<Game> getGamesByGenre(String genre) {
        return gameRepository.findByGenreIgnoreCase(genre);
    }

    public Game addGame(Game game) {
        game.setId(null);
        return gameRepository.save(game);
    }

    public Game updateGame(Long id, Game updatedGame) {
        Game existingGame = getGameById(id);

        existingGame.setTitle(updatedGame.getTitle());
        existingGame.setGenre(updatedGame.getGenre());
        existingGame.setDescription(updatedGame.getDescription());
        existingGame.setReleaseYear(updatedGame.getReleaseYear());
        existingGame.setStatus(updatedGame.getStatus());
        existingGame.setDeveloper(updatedGame.getDeveloper());

        return gameRepository.save(existingGame);
    }

    public void deleteGame(Long id) {
        Game game = getGameById(id);
        gameRepository.delete(game);
    }
}