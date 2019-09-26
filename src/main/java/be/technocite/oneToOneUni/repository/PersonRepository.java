package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.manyToManyBi.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(String name);
}
