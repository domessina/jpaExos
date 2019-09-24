package be.technocite.oneToOneUni.oneToOneBi;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="client_id")
    private CreditCard creditCard;

    public Client(){}

    public Client(CreditCard creditCard) {
        this.creditCard = creditCard;
    }
}
