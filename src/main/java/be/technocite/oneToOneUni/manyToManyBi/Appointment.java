package be.technocite.oneToOneUni.manyToManyBi;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

    @ManyToMany(mappedBy = "appointments")
    Collection<Person> persons;
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;

    protected Appointment() {
    }

    public Appointment(Date date, Collection<Person> persons) {
        this.date = date;
        this.persons = persons;
    }

    public Appointment(Date date) {
        this.date = date;
    }
}
