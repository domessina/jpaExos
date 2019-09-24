package be.technocite.oneToOneUni.model.oneToOneUni;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="address_id", foreignKey = @ForeignKey(name = "nice_fk"))
    private Address address;

    public Customer() {}

    public Customer(Long id, Address address) {
        this.id = id;
        this.address = address;
    }

    public Customer(Address address) {
        this.address = address;
    }
}
