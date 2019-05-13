package nl.YESmovies.testing.persistence;

import nl.YESmovies.testing.model.YesProfile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YesProfileRepository extends CrudRepository<YesProfile,Long> {

    List<YesProfile> findByUserName(String userName);

}
