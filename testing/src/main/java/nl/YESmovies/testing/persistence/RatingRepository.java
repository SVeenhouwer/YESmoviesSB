package nl.YESmovies.testing.persistence;

import nl.YESmovies.testing.model.Rating;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating,Long> {
}
