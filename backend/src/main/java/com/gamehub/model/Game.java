package com.gamehub.model;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String genre;

    @Column(length = 2000)
    private String description;

    private int releaseYear;

    @Enumerated(EnumType.STRING)
    private GameStatus status;

    private String developer;

    public Game() {
    }

    public Game(Long id, String title, String genre,
                String description, int releaseYear,
                GameStatus status, String developer) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.releaseYear = releaseYear;
        this.status = status;
        this.developer = developer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", status=" + status +
                ", developer='" + developer + '\'' +
                '}';
    }
}
