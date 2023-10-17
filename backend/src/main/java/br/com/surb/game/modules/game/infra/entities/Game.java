package br.com.surb.game.modules.game.infra.entities;

import br.com.surb.game.modules.genre.infra.entities.Genre;
import br.com.surb.game.modules.record.infra.entities.Record;
import br.com.surb.game.shared.AppEnums.Platform;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_game")
public class Game implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;
    private String title;
    private Platform platform;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @OneToMany(mappedBy = "game")
    private final List<Record> records = new ArrayList<>();

    public Game() {
    }

    public Game(Long gameId, String title, Platform platform, Genre genre) {
        this.gameId = gameId;
        this.title = title;
        this.platform = platform;
        this.genre = genre;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Record> getRecords() {
        return records;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameId, game.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId);
    }
}
