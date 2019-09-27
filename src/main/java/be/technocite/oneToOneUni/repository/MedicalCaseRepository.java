package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.idString.MedicalCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalCaseRepository extends CrudRepository<MedicalCase, Long> {

}
