package br.com.surb.game.modules.record.services;

import br.com.surb.game.modules.game.infra.entities.Game;
import br.com.surb.game.modules.game.infra.repositories.GameRepository;
import br.com.surb.game.modules.record.dto.RecordCreateDTO;
import br.com.surb.game.modules.record.dto.RecordDTO;
import br.com.surb.game.modules.record.infra.entities.Record;
import br.com.surb.game.modules.record.infra.repositories.RecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordCreateService {

    private final RecordRepository recordRepository;
    private final GameRepository gameRepository;

    public RecordCreateService(RecordRepository recordRepository, GameRepository gameRepository) {
        this.recordRepository = recordRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public RecordDTO execute(RecordCreateDTO dto){
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setCreatedAt(Instant.now());

        Game game = gameRepository.getById(dto.getGameId());
        entity.setGame(game);
        entity = recordRepository.save(entity);
        return new RecordDTO(entity);
    }
}
