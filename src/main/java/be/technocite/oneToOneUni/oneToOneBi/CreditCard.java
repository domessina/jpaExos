package be.technocite.oneToOneUni.oneToOneBi;

import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @GeneratedValue
    private Long id;

//    mappedby fait référence à une propriété Java et non pas une colonne de table SQL
    @Column(name = "client_id")
    private String clientId;

    private int amount;

    public CreditCard() {}

    public CreditCard(String clientId, int amount) {
        this.clientId = clientId;
        this.amount = amount;
    }

    public CreditCard(int amount) {
        this.amount = amount;
    }
}
