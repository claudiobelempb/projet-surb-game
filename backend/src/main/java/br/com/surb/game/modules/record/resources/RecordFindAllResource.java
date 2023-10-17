package br.com.surb.game.modules.record.resources;

import br.com.surb.game.modules.record.dto.RecordDTO;
import br.com.surb.game.modules.record.services.RecordFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping(value = "/records")
public class RecordFindAllResource {

    private final RecordFindAllService recordFindAllService;

    public RecordFindAllResource(RecordFindAllService recordFindAllService) {
        this.recordFindAllService = recordFindAllService;
    }

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> handle(
        @RequestParam(value = "min", defaultValue = "") String min,
        @RequestParam(value = "max", defaultValue = "") String max,
        @RequestParam(value = "page", defaultValue = "0") Integer page,
        @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
        @RequestParam(value = "orderBy", defaultValue = "createdAt") String orderBy,
        @RequestParam(value = "direction", defaultValue = "DESC") String direction
    )
    {
        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if(linesPerPage == 0){
            linesPerPage = Integer.MAX_VALUE;
        }

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        Page<RecordDTO> recordDTOS = recordFindAllService.execute(minDate, maxDate, pageRequest);
        return ResponseEntity.ok().body(recordDTOS);
    }

//    @GetMapping()
//    public Page<RecordDTO> handle(Pageable pageable)
//    {
//        /*PARAMETRISE: page, size, direction, sort*/
//        return recordFindAllService.execute(pageable);
//    }
}
