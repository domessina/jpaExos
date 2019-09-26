package be.technocite.oneToOneUni.manyToManyBi;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "person_appointment", joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = @JoinColumn(name = "appointment_id"))
    private Collection<Appointment> appointments;

    public Person(String name, Collection<Appointment> appointments) {
        this.name = name;
        this.appointments = appointments;
    }
}
