package fr.telecomnancy.sdproject.model;

import java.util.Date;
import java.util.Set;

/**
 * @author Zakaria BENJEBARA.
 */
public class Actor extends Person {

    private Set<Movie> movies;

    public Actor(int id, String firstName, String lastName,
                 Date birthDay, City born, String biography, Set<Movie> movies) {
        super(id, firstName, lastName, birthDay, born, biography);
        this.movies = movies;
    }

    public Actor() {
        super();
    }

    public Set<Movie> getMovies() {
        return movies;
    }
}
