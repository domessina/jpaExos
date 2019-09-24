package be.technocite.oneToOneUni.oneToManyBi;

import javax.persistence.*;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue
    private Long id;

    private int number;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cruise cruise;

    protected Reservation() {}

    public Reservation(int number) {
        this.number = number;
    }
}
