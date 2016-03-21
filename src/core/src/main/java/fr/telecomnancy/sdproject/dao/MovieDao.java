package fr.telecomnancy.sdproject.dao;

import fr.telecomnancy.sdproject.model.Movie;

/**
 * @author Zakaria BENJEBARA.
 */
public class MovieDao extends JsonDaoHelper<Movie> {

    private static final String movieFile = "movie.json";

    public MovieDao() {
    }

    @Override
    protected String filePath() {
        return movieFile;
    }

    @Override
    protected Class<?> getModelClass() {
        return Movie.class;
    }
}
