package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.Movie;
import nl.YESmovies.testing.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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



}
