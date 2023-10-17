package br.com.surb.game.modules.game.mapper;

import br.com.surb.game.modules.game.dto.GameDTO;
import br.com.surb.game.modules.game.infra.entities.Game;

public class GameMapper {

    public void toDTO(Game entity, GameDTO dto) {
        entity.setTitle(dto.getTitle());
        entity.setPlatform(dto.getPlatform());
    }
}
