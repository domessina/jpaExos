package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.manyToManyBi.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
