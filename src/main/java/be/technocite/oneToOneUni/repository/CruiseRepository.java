package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.oneToManyBi.Cruise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseRepository extends CrudRepository<Cruise, Long> {
}
