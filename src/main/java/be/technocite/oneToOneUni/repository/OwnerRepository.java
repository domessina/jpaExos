package be.technocite.oneToOneUni.repository;

import be.technocite.oneToOneUni.oneToMany.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository  extends CrudRepository<Owner, Long> {
}
