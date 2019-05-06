package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.Genre;
import nl.YESmovies.testing.service.GenreService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/movies")
public class GenreController {

    private GenreService genreService;

    public GenreController(GenreService genreService){
        this.genreService = genreService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Genre>> list(){
        return ResponseEntity.ok(this.genreService.findAll());
    }

    @PostMapping
    public Genre create(@RequestBody Genre genre){
        return this.genreService.save(genre);
    }

    @GetMapping("{id}")
    public Genre get(@PathVariable long id) {
        Optional<Genre> optionalResult = this.genreService.findById(id);
        if(optionalResult.isPresent()) {
            Genre result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{id}")
    public Genre update(@PathVariable long id, @RequestBody Genre input) {
        Optional<Genre> optionalTarget = this.genreService.findById(id);
        if(optionalTarget.isPresent()) {
            Genre target = optionalTarget.get();
            target.setName(input.getName());
            return this.genreService.save(target);
        } else {
            return null; // fix this later
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Genre> optionalResult = this.genreService.findById(id);
        if(optionalResult.isPresent()) {
            this.genreService.deleteById(id);
        }
    }

}
