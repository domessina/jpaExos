package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.idString.MedicalCase;
import be.technocite.oneToOneUni.manyToManyBi.Person;
import be.technocite.oneToOneUni.model.oneToOneUni.Customer;
import be.technocite.oneToOneUni.oneToMany.Owner;
import be.technocite.oneToOneUni.oneToMany.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;

@Repository
public class JpqlRepository {

    @Autowired
    private EntityManager entityManager;

    public Customer findCustomerById(Long id) {
        return entityManager.find(Customer.class, id);
    }

   /* public List<Object[2]> selectAllPersonsNameAndId() {
        return entityManager.createQuery("select p.id, p.name from Person as p")
                .getResultList();
    }*/

    public List<Phone> selectPhoneByOwnerId(Long ownerId, String brand) {
        return entityManager.createQuery("from Phone where owner_id = :ownerId and brand = :brand", Phone.class)
                .setParameter("ownerId", ownerId)
                .setParameter("brand", brand)
                .getResultList();
    }

    public List<Phone> selectPhoneByBrandsInOwner(Collection<String> brands, Long ownerId) {
        return entityManager.createQuery("from Phone p where owner_id = :ownerId and p.brand in :brands", Phone.class)
                .setParameter("ownerId", ownerId)
                .setParameter("brands", brands)
                .getResultList();
    }

    //le owner est l'entité maître et Phone l'entité esclave. De tous les phones de tous les owners tous les phones
    //sont uniques de par leur colonne owner_id. Ceci nous permet avec assurance de trouver un owner par son phone
    public Owner findOwnerByPhone(Phone phone) {
        return entityManager.createQuery("from Owner o where :phone member of o.phones", Owner.class)
                .setParameter("phone", phone)
                .getSingleResult();
    }

    public List<Person> findAllOrdered() {
        return entityManager.createQuery("from Person p order by lower(p.name)", Person.class)
                .getResultList();
    }

    // Attention le select p avant est important pour ne pas que Hibernate croie qu'il faut retourner les appointements et places avec les personnes
    public List<Person> findPersonsConcernedByPlaceName(String text) {
        return entityManager.createQuery("select p from Person p left join p.appointments a left join a.places pl where a.date is not null and p.name is not empty and pl.cityName = :text", Person.class)
                .setParameter("text", text)
                .getResultList();
    }

    // jointure avec id String et non par objet entité
    public List<MedicalCase> findByNissAndIllnessId(String illnessName) {
        return entityManager.createQuery("select distinct mc1 from MedicalCase mc1, Illness i where mc1.illnessId = i.id and lower(i.name) like :illnessName", MedicalCase.class)
                .setParameter("illnessName", "%" + illnessName + "%")
                .getResultList();
    }

    /*SELECT DISTINCT mag1 FROM Magazine mag1, Magazine mag2
WHERE mag1.price > mag2.price AND mag2.publisher.name = 'Adventure'*/

}
