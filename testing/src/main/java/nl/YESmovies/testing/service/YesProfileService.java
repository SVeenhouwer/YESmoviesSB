package nl.YESmovies.testing.service;

import nl.YESmovies.testing.model.YesProfile;
import nl.YESmovies.testing.persistence.YesProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YesProfileService {

    private YesProfileRepository yesProfileRepository;

    public YesProfileService(YesProfileRepository yesProfileRepository) {
        this.yesProfileRepository = yesProfileRepository;
    }

    public YesProfile save(YesProfile yesProfile) {
        return this.yesProfileRepository.save(yesProfile);
    }

    public Optional<YesProfile> findById(Long aLong) {
        return yesProfileRepository.findById(aLong);
    }

    public List<YesProfile> findByUserName(String userName) {
        return this.yesProfileRepository.findByUserName(userName);
    }

    public Iterable<YesProfile> findAll() {
        return yesProfileRepository.findAll();
    }

    public void deleteById(Long aLong) {
        yesProfileRepository.deleteById(aLong);
    }
}
