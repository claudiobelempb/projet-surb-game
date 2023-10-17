package br.com.surb.game.modules.game.services;

import br.com.surb.game.modules.game.dto.GameDTO;
import br.com.surb.game.modules.game.infra.entities.Game;
import br.com.surb.game.modules.game.infra.repositories.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameFindAllService {
    private final GameRepository gameRepository;
    public GameFindAllService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public Page<GameDTO> execute(Pageable pageable){
        Page<Game> games = gameRepository.findAll(pageable);
        return games.map(movie -> new GameDTO(movie));
    }
}
