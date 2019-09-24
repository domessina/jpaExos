package be.technocite.oneToOneUni.oneToManyBi;

import javax.persistence.*;
import java.util.Collection;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "cruise")
public class Cruise {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(cascade = ALL)
    @JoinColumn(name = "cruise_id") // crée la colonne cruise_id dans la table reservation
    private Collection<Reservation> reservations;

    protected Cruise() {}

    public Cruise(String name, Collection<Reservation> reservations) {
        this.name = name;
        this.reservations = reservations;
    }
}
