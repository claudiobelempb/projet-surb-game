package br.com.surb.game.modules.record.infra.entities;

import br.com.surb.game.modules.game.infra.entities.Game;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_record")
public class Record implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;
    private String name;
    private Integer age;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    public Record() {
    }

    public Record(Long recordId, String name, Integer age, Instant createdAt, Game game) {
        this.recordId = recordId;
        this.name = name;
        this.age = age;
        this.createdAt = createdAt;
        this.game = game;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(recordId, record.recordId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recordId);
    }
}
