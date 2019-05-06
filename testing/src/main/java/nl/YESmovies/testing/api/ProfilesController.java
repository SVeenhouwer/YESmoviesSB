package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.Profiles;
import nl.YESmovies.testing.service.ProfilesService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/profiles")
public class ProfilesController {

    private ProfilesService profilesService;

    public ProfilesController(ProfilesService profilesService){
        this.profilesService = profilesService;
    }

    @GetMapping
    public Iterable<Profiles> list(){
        return this.profilesService.findAll();
    }

    @PostMapping
    public Profiles create(@RequestBody Profiles profiles){
        return this.profilesService.save(profiles);
    }

    @GetMapping("{id}")
    public Profiles get(@PathVariable long id) {
        Optional<Profiles> optionalResult = this.profilesService.findById(id);
        if (optionalResult.isPresent()) {
            Profiles result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{id}")
    public Profiles update(@PathVariable long id, @RequestBody Profiles input) {
        Optional<Profiles> optionalTarget = this.profilesService.findById(id);
        if (optionalTarget.isPresent()) {
            Profiles target = optionalTarget.get();
            target.setUserName(input.getUserName());
            return this.profilesService.save(target);
        } else {
            return null; // fix this later!!!
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<Profiles> optionalResult = this.profilesService.findById(id);
        if(optionalResult.isPresent()) {
            this.profilesService.deleteById(id);
        }
    }
}
