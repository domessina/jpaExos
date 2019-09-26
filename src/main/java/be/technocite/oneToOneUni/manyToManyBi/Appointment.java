package be.technocite.oneToOneUni.manyToManyBi;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date date;
    @ManyToMany(mappedBy = "appointments")
    private Collection<Person> persons;

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
