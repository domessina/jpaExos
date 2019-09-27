package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.idString.Illness;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IllnessRepository extends CrudRepository<Illness, Long> {
}
