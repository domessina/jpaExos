package be.technocite.oneToOneUni.maniToOneUni;

import javax.persistence.*;

@Entity
@Table(name = "journey")
public class Journey {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "ship_Id")
    private Ship ship;

    protected Journey() {}

    public Journey(String name, Ship ship) {
        this.name = name;
        this.ship = ship;
    }
}
