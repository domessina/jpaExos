package be.technocite.oneToOneUni.manyToManyBi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "place")
public class Place {

    @Id
    @GeneratedValue
    private Long id;

    private String cityName;

    protected Place() {
    }

    public Place(String cityName) {
        this.cityName = cityName;
    }
}
