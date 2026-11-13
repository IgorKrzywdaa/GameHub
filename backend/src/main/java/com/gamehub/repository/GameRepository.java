package com.gamehub.repository;

import com.gamehub.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByGenreIgnoreCase(String genre);
}