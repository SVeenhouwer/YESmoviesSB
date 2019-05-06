package nl.YESmovies.testing.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private float yesRating;

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
