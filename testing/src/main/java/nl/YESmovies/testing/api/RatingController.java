package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.Movie;
import nl.YESmovies.testing.model.Rating;
import nl.YESmovies.testing.service.MovieService;
import nl.YESmovies.testing.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/ratings")
public class RatingController {

    private RatingService ratingService;
    private MovieService movieService;

    public RatingController(RatingService ratingService, MovieService movieService){
        this.ratingService = ratingService;
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Rating>> list(){
        return ResponseEntity.ok(this.ratingService.findAll());
    }

    @PostMapping
    public Rating create(@RequestBody Rating rating){
        return this.ratingService.save(rating);
    }

    @PostMapping("{movieId}/addRating")
    public Rating addRating(@PathVariable long movieId, @RequestBody Rating rating) {
        Optional<Movie> optionalMovie = this.movieService.findById(movieId);
        if (optionalMovie.isPresent()) {
            this.ratingService.save(rating);
            (optionalMovie.get()).addRating(rating);
            this.ratingService.save(rating);
            this.movieService.save(optionalMovie.get());
            return rating;
        } else {
            return null; // fix this later ??
        }
    }

    @GetMapping("{id}")
    public Rating get(@PathVariable long id) {
        Optional<Rating> optionalResult = this.ratingService.findById(id);
        if(optionalResult.isPresent()) {
            Rating result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{id}")
    public Rating update(@PathVariable long id, @RequestBody Rating input) {
        Optional<Rating> optionalTarget = this.ratingService.findById(id);
        if(optionalTarget.isPresent()) {
            Rating target = optionalTarget.get();
            target.setYesRating(input.getYesRating());
            return this.ratingService.save(target);
        } else {
            return null; // fix this later
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Rating> optionalResult = this.ratingService.findById(id);
        if(optionalResult.isPresent()) {
            this.ratingService.deleteById(id);
        }
    }
}
