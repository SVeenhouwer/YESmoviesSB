package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.Genre;
import nl.YESmovies.testing.model.Movie;
import nl.YESmovies.testing.model.Rating;
import nl.YESmovies.testing.persistence.GenreRepository;
import nl.YESmovies.testing.service.GenreService;
import nl.YESmovies.testing.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private MovieService movieService;
    private GenreService genreService;

    public MovieController(MovieService movieService, GenreService genreService){

        this.movieService = movieService;
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Movie>> list(){
        return ResponseEntity.ok(this.movieService.findAll());
    }

    @PostMapping
    public Movie create(@RequestBody Movie movie){
        LocalDate now = LocalDate.now();
        if (movie.getReleaseYear() > 1888 && movie.getReleaseYear() < now.getYear() &&
                movie.getImdbRating() > 0 && movie.getImdbRating() < 10
        && this.movieService.findByTitleAndReleaseYear(movie.getTitle(),movie.getReleaseYear()).size() < 1) {
            return this.movieService.save(movie);
        } else {
            return null; //fix this later
        }
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

    @PutMapping("{movieId}/addgenre/{genreId}")
    public void addGenreToMovie(@PathVariable long movieId, @PathVariable long genreId) {
        // fetch movie
        Optional<Movie> optionalMovie = this.movieService.findById(movieId);
        // fetch genre
        Optional<Genre> optionalGenre = this.genreService.findById(genreId);

        // add genre to movie list
        if (optionalMovie.isPresent() && optionalGenre.isPresent()) {
            (optionalMovie.get()).addGenre(optionalGenre.get());
            this.movieService.save(optionalMovie.get());
            this.genreService.save(optionalGenre.get());
        }

    }

//    @PutMapping("{movieId}/addrating/{ratingId}")
//    public void addRatingToMovie(@PathVariable long movieId, @PathVariable long ratingId) {
//        // fetch movie
//        Optional<Movie> optionalMovie = this.movieService.findById(movieId);
//        // fetch genre
//        Optional<Rating> optionalRating = this.genreService.findById(ratingId);
//
//        // add genre to movie list
//        if (optionalMovie.isPresent() && optionalGenre.isPresent()) {
//            (optionalMovie.get()).addGenre(optionalGenre.get());
//        }
//    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Movie> optionalResult = this.movieService.findById(id);
        if(optionalResult.isPresent()) {
            this.movieService.deleteById(id);
        }
    }

}
