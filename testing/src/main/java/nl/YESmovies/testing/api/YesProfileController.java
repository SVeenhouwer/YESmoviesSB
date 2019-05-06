package nl.YESmovies.testing.api;

import nl.YESmovies.testing.model.YesProfile;
import nl.YESmovies.testing.service.YesProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/profiles")
public class YesProfileController {

    private YesProfileService yesProfileService;

    public YesProfileController(YesProfileService yesProfileService){
        this.yesProfileService = yesProfileService;
    }

    @GetMapping
    public Iterable<YesProfile> list(){
        return this.yesProfileService.findAll();
    }

    @PostMapping
    public YesProfile create(@RequestBody YesProfile profiles){
        return this.yesProfileService.save(profiles);
    }

    @GetMapping("{id}")
    public YesProfile get(@PathVariable long id) {
        Optional<YesProfile> optionalResult = this.yesProfileService.findById(id);
        if (optionalResult.isPresent()) {
            YesProfile result = optionalResult.get();
            return result;
        } else {
            return null; // fix this later!
        }
    }

    @PutMapping("{id}")
    public YesProfile update(@PathVariable long id, @RequestBody YesProfile input) {
        Optional<YesProfile> optionalTarget = this.yesProfileService.findById(id);
        if (optionalTarget.isPresent()) {
            YesProfile target = optionalTarget.get();
            target.setUserName(input.getUserName());
            return this.yesProfileService.save(target);
        } else {
            return null; // fix this later!!!
        }
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable long id) {
        Optional<YesProfile> optionalResult = this.yesProfileService.findById(id);
        if(optionalResult.isPresent()) {
            this.yesProfileService.deleteById(id);
        }
    }
}
