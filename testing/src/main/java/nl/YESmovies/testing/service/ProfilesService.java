package nl.YESmovies.testing.service;

import nl.YESmovies.testing.model.Profiles;
import nl.YESmovies.testing.persistence.ProfilesRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProfilesService {

    private ProfilesRepository profilesRepository;

    public ProfilesService(ProfilesRepository profilesRepository) {
        this.profilesRepository = profilesRepository;
    }

    public Profiles save(Profiles brush) {
        return this.profilesRepository.save(brush);
    }

    public Optional<Profiles> findById(Long aLong) {
        return profilesRepository.findById(aLong);
    }

    public Iterable<Profiles> findAll() {
        return profilesRepository.findAll();
    }

    public void deleteById(Long aLong) {
        profilesRepository.deleteById(aLong);
    }
}
