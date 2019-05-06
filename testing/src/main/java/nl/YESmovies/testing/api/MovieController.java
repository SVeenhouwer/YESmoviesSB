package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.Movie;
import nl.YESmovies.testing.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> list(){
        return ResponseEntity.ok(this.movieService.findAll());
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie){
        return this.movieService.save(movie);
    }

    @GetMapping("{id}")
    public Movie get(@PathVariable long id) {
        Optional<Movie> optionalResult = this.movieService.findById(id);
        if(optionalResult.isPresent()) {
            Movie result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{id}")
    public Movie update(@PathVariable long id, @RequestBody Movie input) {
        Optional<Movie> optionalTarget = this.movieService.findById(id);
        if(optionalTarget.isPresent()) {
            Movie target = optionalTarget.get();
            target.setTitle(input.getTitle());
            target.setReleaseYear(input.getReleaseYear());
            target.setImdbRating(input.getImdbRating());
            return this.movieService.save(target);
        } else {
            return null; // fix this later
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Movie> optionalResult = this.movieService.findById(id);
        if(optionalResult.isPresent()) {
            this.movieService.deleteById(id);
        }
    }

}
