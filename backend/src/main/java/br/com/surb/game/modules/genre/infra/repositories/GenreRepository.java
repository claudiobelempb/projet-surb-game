package br.com.surb.game.modules.genre.infra.repositories;

import br.com.surb.game.modules.genre.infra.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
