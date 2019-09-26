package be.technocite.oneToOneUni.maniToOneUni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ship")
public class Ship {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    protected Ship() {}


    public Ship(String name) {
        this.name = name;
    }
}
