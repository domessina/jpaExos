package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.manyToManyBi.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {


}
