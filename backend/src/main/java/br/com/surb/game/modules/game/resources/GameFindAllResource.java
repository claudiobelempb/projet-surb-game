package br.com.surb.game.modules.game.resources;

import br.com.surb.game.modules.game.dto.GameDTO;
import br.com.surb.game.modules.game.services.GameFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameFindAllResource {

    private final GameFindAllService gameFindAllService;

    public GameFindAllResource(GameFindAllService gameFindAllService) {
        this.gameFindAllService = gameFindAllService;
    }

    @GetMapping()
    public Page<GameDTO> handle(Pageable pageable)
    {
        /*PARAMETRISE: page, size, direction, sort*/
       return gameFindAllService.execute(pageable);
    }
}
