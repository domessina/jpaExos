package be.technocite.oneToOneUni.model.oneToOneUni;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private int number;

    public  Address() {}

    public Address(Long id, String street, int number) {
        this.street = street;
        this.number = number;
    }

    public Address(String street, int number) {
        this.street = street;
        this.number = number;
    }
}
