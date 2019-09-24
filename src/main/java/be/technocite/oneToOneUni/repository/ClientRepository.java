package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.oneToOneBi.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
