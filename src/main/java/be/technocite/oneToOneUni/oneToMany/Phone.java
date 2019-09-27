package be.technocite.oneToOneUni.oneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "phone")
public class Phone {


    @Id
    @GeneratedValue
    private Long id;

    private String brand;

    public Phone(String brand) {
        this.brand = brand;
    }
    
    protected Phone() {}

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
