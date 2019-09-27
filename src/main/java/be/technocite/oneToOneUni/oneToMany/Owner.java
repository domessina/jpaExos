package be.technocite.oneToOneUni.oneToMany;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade={CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    private Collection<Phone> phones;

    protected Owner() {}

    public Owner(Collection<Phone> phones) {
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public Collection<Phone> getPhones() {
        return phones;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", phones=" + phones +
                '}';
    }
}
