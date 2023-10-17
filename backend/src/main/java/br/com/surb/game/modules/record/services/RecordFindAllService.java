package br.com.surb.game.modules.record.services;

import br.com.surb.game.modules.record.dto.RecordDTO;
import br.com.surb.game.modules.record.infra.repositories.RecordRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordFindAllService {

    private final RecordRepository  recordRepository;

    public RecordFindAllService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    @Transactional(readOnly = true)
    public Page<RecordDTO> execute(Instant minDate, Instant maxDate, PageRequest pageRequest){
        return recordRepository.findByMoments(minDate, maxDate, pageRequest).map((record) -> new RecordDTO(record));
    }

//    @Transactional(readOnly = true)
//    public Page<RecordDTO> execute(PageRequest pageRequest){
//        Page<Record> records = recordRepository.findAll(pageRequest);
//        return records.map(record -> new RecordDTO(record));
//    }
}
