package nl.YESmovies.testing.persistence;

import nl.YESmovies.testing.model.Profiles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilesRepository extends CrudRepository<Profiles,Long> {

}
