package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.maniToOneUni.Ship;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipRepository extends CrudRepository<Ship, Long> {
}
