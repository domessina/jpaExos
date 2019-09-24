package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.model.oneToOneUni.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
