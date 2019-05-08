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
    private String userName;
    private ArrayList<String> watchedMovies;

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

    public ArrayList<String> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(ArrayList<String> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
}
