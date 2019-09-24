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
}
