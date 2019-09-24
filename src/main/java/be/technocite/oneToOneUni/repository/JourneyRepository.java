package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.maniToOneUni.Journey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JourneyRepository extends CrudRepository<Journey, Long> {
}
