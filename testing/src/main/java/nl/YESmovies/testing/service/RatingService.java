package nl.YESmovies.testing.service;

import nl.YESmovies.testing.model.Rating;
import nl.YESmovies.testing.persistence.RatingRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public Rating save(Rating rating) {
        return this.ratingRepository.save(rating);
    }

    public Optional<Rating> findById(Long aLong) {
        return ratingRepository.findById(aLong);
    }

    public Iterable<Rating> findAll() {
        return ratingRepository.findAll();
    }

    public void deleteById(Long aLong) {
        ratingRepository.deleteById(aLong);
    }
}
