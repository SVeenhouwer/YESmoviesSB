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

    @ManyToMany(mappedBy="watchedBy", cascade=CascadeType.ALL)
    private Set<Movie> watchedMovies = new HashSet<>();

    public void addMovie(Movie movie){
        this.watchedMovies.add(movie);
        movie.getWatchedBy().add(this);
    }

    private String userName;
    //private ArrayList<String> watchedMovies;

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
