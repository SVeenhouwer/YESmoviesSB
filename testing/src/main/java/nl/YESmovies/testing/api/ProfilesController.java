package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.Profiles;
import nl.YESmovies.testing.service.ProfilesService;
import org.springframework.web.bind.annotation.*;

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
}
