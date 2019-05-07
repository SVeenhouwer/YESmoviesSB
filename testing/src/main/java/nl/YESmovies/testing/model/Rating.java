package nl.YESmovies.testing.model;

import javax.persistence.*;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float yesRating;

    @ManyToOne
    private Movie movie;

    public long getId() {
        return id;
    }

    public float getYesRating() {
        return yesRating;
    }

    public void setYesRating(float yesRating) {
        this.yesRating = yesRating;
    }
}
