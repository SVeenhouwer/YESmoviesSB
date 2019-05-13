package nl.YESmovies.testing.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


@Entity
public class YesProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "yesProfile")
    private Set<Rating> ratedMovies = new HashSet<>();

    public Set<Rating> getRatedMovies() {
        return this.ratedMovies;
    }

    public void addRating(Rating rating) {
        this.ratedMovies.add(rating);
        rating.setYesProfile(this);
    }

    @ManyToMany(mappedBy="watchedBy", cascade=CascadeType.ALL)
    private Set<Movie> watchedMovies = new HashSet<>();

    public void addMovie(Movie movie){
        this.watchedMovies.add(movie);
        movie.getWatchedBy().add(this);
    }

    private String userName;
    //private ArrayList<String> watchedMovies;

    @ManyToMany(mappedBy = "profilesPreferringGenre", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("profilesPreferringGenre")
    private Set<Genre> preferredGenres = new HashSet<>();

    public void addGenre(Genre genre) {
        this.preferredGenres.add(genre);
        genre.getProfilesPreferringGenre().add(this);
    }

    public Set<Genre> getPreferredGenres() {
        return preferredGenres;
    }

    public void setPreferredGenres(Set<Genre> preferredGenres) {
        this.preferredGenres = preferredGenres;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

/*    public ArrayList<String> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(ArrayList<String> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }*/

    public Set<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(Set<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
}
