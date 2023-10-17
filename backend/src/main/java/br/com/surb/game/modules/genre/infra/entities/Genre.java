package br.com.surb.game.modules.genre.infra.entities;

import br.com.surb.game.modules.game.infra.entities.Game;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tb_genre")
public class Genre implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreId;
    private String name;

    @OneToMany(mappedBy = "genre")
    private List<Game> games = new ArrayList<>();

    public Genre() {
    }

    public Genre(Long genreId, String name) {
        this.genreId = genreId;
        this.name = name;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(genreId, genre.genreId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genreId);
    }
}
