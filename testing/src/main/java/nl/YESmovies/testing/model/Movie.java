package nl.YESmovies.testing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Movie {
    public static ArrayList<Movie> movieObjectList = new ArrayList<>();
    public static ArrayList<String> movieList = new ArrayList<>();
    //private ArrayList<Float> ratingList = new ArrayList<Float>() ;                 //all rating for one movie. moved to Movie Class
    private HashMap<String,Float> ratingList = new HashMap<String, Float>();

    public static int movieCounter = 0;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private short releaseYear;
    private float yesRating;
    private int nrRatings;
    private float imdbRating;

    public void addYesRating(String userName, float rating) {
        ratingList.put(userName, rating);
        double total = 0;
        for(Map.Entry<String, Float> rated : ratingList.entrySet()){
            total += rated.getValue();
        }
        this.nrRatings = ratingList.size();

        this.yesRating = (float)Math.round((total / nrRatings)*10)/10;
    }

    public HashMap<String,Float> getRatingList(){
        return ratingList;
    }

    public float getYesRating() {
        return this.yesRating;
    }
    
    public Movie(String title, short releaseYear, float imdbRating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.id = ++movieCounter;
        this.imdbRating = imdbRating;
        movieList.add(title);
    }

    private String[] genresString = {"Action", "Adventure", "Animation", "Biography", "Comedy", "Crime", "Documentary",
            "Drama", "Family", "Fantasy", "Film Noir", "History", "Horror", "Music", "Musical", "Mystery", "Romance",
            "Sci-Fi", "Short", "Sport", "Superhero", "Thriller", "War", "Western"};

    private int[] genreInt = new int[genresString.length];

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(short releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int[] getGenreInt() {
        return genreInt;
    }

    public void addGenre(int index) {
        this.genreInt[index] = 1;
    }

    public void removeGenre(int index) {
        this.genreInt[index] = 0;
    }

    public String getGenreString(){
        String movieGenre = "";
        for (int i = 0; i < genresString.length; i++){
            if(genreInt[i] == 1){
                movieGenre += genresString[i]+" ";
            }
        }
        return movieGenre;
    }

    public float getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(float imdbRating) {
        this.imdbRating = imdbRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseYear=" + releaseYear +
                ", genres=" + this.getGenreString() +
                '}';
    }
}