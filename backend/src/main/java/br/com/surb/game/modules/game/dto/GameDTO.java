package br.com.surb.game.modules.game.dto;

import br.com.surb.game.modules.game.infra.entities.Game;
import br.com.surb.game.shared.AppEnums.Platform;

import java.io.Serial;
import java.io.Serializable;

public class GameDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Long gameId;
    private String title;
    private Platform platform;

    public GameDTO() {
    }

    public GameDTO(Long gameId, String title, Platform platform) {
        this.gameId = gameId;
        this.title = title;
        this.platform = platform;
    }

    public GameDTO(Game entity){
        gameId = entity.getGameId();
        title = entity.getTitle();
        platform = entity.getPlatform();
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

}
