package be.technocite.oneToOneUni.repository;

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

    public List<Person> selectAllPersonsNameAndId() {
        return entityManager.createQuery("select p.id, p.name from Person as p", Person.class)
                .getResultList();
    }

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

    public Collection<Person> findAllOrdered() {
        return entityManager.createQuery("from Person p order by lower(p.name)", Person.class)
                .getResultList();
    }


}
