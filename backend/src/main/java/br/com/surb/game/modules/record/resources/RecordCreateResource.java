package br.com.surb.game.modules.record.resources;

import br.com.surb.game.modules.record.dto.RecordCreateDTO;
import br.com.surb.game.modules.record.dto.RecordDTO;
import br.com.surb.game.modules.record.services.RecordCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/records")
public class RecordCreateResource {

    private final RecordCreateService recordCreateService;

    public RecordCreateResource(RecordCreateService recordCreateService) {
        this.recordCreateService = recordCreateService;
    }

    @PostMapping
    public ResponseEntity<RecordDTO> handle(@RequestBody RecordCreateDTO dto){
        RecordDTO recordDTO = recordCreateService.execute(dto);
        return ResponseEntity.ok().body(recordDTO);
    }
}
