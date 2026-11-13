package com.gamehub.controller;

import com.gamehub.model.Game;
import com.gamehub.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "*")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<Game>> getAllGames() {
        return ResponseEntity.ok(gameService.getAllGames());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        return ResponseEntity.ok(gameService.getGameById(id));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Game>> getGamesByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(gameService.getGamesByGenre(genre));
    }

    @PostMapping
    public ResponseEntity<Game> addGame(@RequestBody Game game) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(gameService.addGame(game));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(
            @PathVariable Long id,
            @RequestBody Game game) {
        return ResponseEntity.ok(gameService.updateGame(id, game));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable Long id) {
        gameService.deleteGame(id);
        return ResponseEntity.noContent().build();
    }
}