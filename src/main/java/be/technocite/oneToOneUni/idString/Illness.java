package be.technocite.oneToOneUni.idString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "illness")
public class Illness {

    @Id
    @GeneratedValue
    private Long id;

    private int gravityLevel;
    private String name;

    protected Illness() {
    }

    public Illness(int gravityLevel, String name) {
        this.gravityLevel = gravityLevel;
        this.name = name;
    }

    public Long getId() {
        return id;
    }
}
