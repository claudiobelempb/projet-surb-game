package br.com.surb.game.modules.game.infra.repositories;

import br.com.surb.game.modules.game.infra.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
