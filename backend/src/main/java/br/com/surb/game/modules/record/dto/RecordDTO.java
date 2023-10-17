package br.com.surb.game.modules.record.dto;

import br.com.surb.game.modules.record.infra.entities.Record;
import br.com.surb.game.shared.AppEnums.Platform;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

public class RecordDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 7082812498339998305L;
    private Long recordId;
    private String name;
    private Integer age;
    private Instant createdAt;
    private String gameTitle;
    private Platform gamePlatform;
    private String genreName;
    public RecordDTO() {
    }

    public RecordDTO(Long recordId, String name, Integer age, Instant createdAt, String gameTitle, Platform gamePlatform, String genreName) {
        this.recordId = recordId;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
        this.gameTitle = gameTitle;
        this.gamePlatform = gamePlatform;
        this.genreName = genreName;
    }

    public RecordDTO(Record entity){
        recordId = entity.getRecordId();
        name = entity.getName();
        age = entity.getAge();
        createdAt = entity.getCreatedAt();
        gameTitle = entity.getGame().getTitle();
        gamePlatform = entity.getGame().getPlatform();
        genreName = entity.getGame().getGenre().getName();
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public Platform getGamePlatform() {
        return gamePlatform;
    }

    public void setGamePlatform(Platform gamePlatform) {
        this.gamePlatform = gamePlatform;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
