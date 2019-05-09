package nl.YESmovies.testing.model;

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

    private String userName;
    private ArrayList<String> watchedMovies;

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
