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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "person_appointment", joinColumns = {@JoinColumn(name = "person_id")},
            inverseJoinColumns = @JoinColumn(name = "appointment_id"))
    private Collection<Appointment> appointments;

    protected Person() {
    }

    public Person(String name, Collection<Appointment> appointments) {
        this.name = name;
        this.appointments = appointments;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", appointments=" + appointments +
                '}';
    }
}
