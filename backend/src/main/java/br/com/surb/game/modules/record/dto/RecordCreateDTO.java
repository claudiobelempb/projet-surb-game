package br.com.surb.game.modules.record.dto;

import br.com.surb.game.modules.record.infra.entities.Record;

import java.io.Serial;
import java.io.Serializable;

public class RecordCreateDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private Integer age;
    private Long gameId;

    public RecordCreateDTO() {
    }

    public RecordCreateDTO(String name, Integer age, Long gameId) {
        this.name = name;
        this.age = age;
        this.gameId = gameId;
    }
    public RecordCreateDTO(Record entity){
        name = entity.getName();
        age = entity.getAge();
        gameId = entity.getGame().getGameId();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
