package nl.YESmovies.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"genresOfMovie","watchedBy","receivedRatings"})
    private Set<Movie> moviesWithGenre = new HashSet<>();

    public void addMovie(Movie movie){
        this.moviesWithGenre.add(movie);
        movie.getGenresOfMovie().add(this);
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"preferredGenres","ratedMovies","watchedMovies"})
    private Set<YesProfile> profilesPreferringGenre = new HashSet<>();

    public void addYesProfile(YesProfile yesProfile) {
        this.profilesPreferringGenre.add(yesProfile);
        yesProfile.getPreferredGenres().add(this);
    }

    public Set<YesProfile> getProfilesPreferringGenre() {
        return profilesPreferringGenre;
    }

    public void setProfilesPreferringGenre(Set<YesProfile> profilesPreferringGenre) {
        this.profilesPreferringGenre = profilesPreferringGenre;
    }

    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMoviesWithGenre() {
        return moviesWithGenre;
    }

    public void setMoviesWithGenre(Set<Movie> moviesWithGenre) {
        this.moviesWithGenre = moviesWithGenre;
    }
}
