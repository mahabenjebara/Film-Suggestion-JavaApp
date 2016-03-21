package fr.telecomnancy.sdproject.dao;

import fr.telecomnancy.sdproject.model.Actor;
import fr.telecomnancy.sdproject.model.City;
import fr.telecomnancy.sdproject.model.Director;
import fr.telecomnancy.sdproject.model.Movie;
import fr.telecomnancy.sdproject.model.Movie.Genre;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@RunWith(JUnit4.class)
public class MovieDaoTest {

    private Set<Genre> genres = new HashSet<>();

    private Movie avatarMovie;
    private Movie movie1;
    private Movie movie2;

    @Before
    public void beforeTest() {
        Director director1 = new Director(1, "Francis Ford", "Coppola", new Date(1939, 4, 7),
                new City("Detroit, Michigan", "USA"), "Francis Ford Coppola was born in 1939 in " +
                "Detroit, Michigan, but grew up in a New York suburb in a creative, " +
                "supportive Italian-American family. His father, Carmine Coppola, " +
                "was a composer and musician. His mother, Italia Coppola (née Pennino), " +
                "had been an actress. Francis Ford Coppola graduated with a degree in drama " +
                "from Hofstra University, and did graduate work at UCLA in filmmaking.", null);

        Set<Movie.Genre> genres1 = new HashSet<>();
        genres1.add(new Movie.Genre("Crime"));
        genres1.add(new Movie.Genre("Drama"));

        Set<Actor> actors1 = new HashSet<>();
        actors1.add(new Actor(1, "Marlon", "Brando", new Date(1924, 4, 3),
                new City("Ohama, Nebraska", "USA"), "Marlon Brando is widely considered the greatest movie " +
                "actor of all time, rivaled only by the more theatrically oriented Laurence Olivier " +
                "in terms of esteem. Unlike Olivier, who preferred the stage to the screen, " +
                "Brando concentrated his talents on movies after bidding the Broadway stage adieu in 1949," +
                " a decision for which he was severely criticized when his star began to dim in the 1960s " +
                "and he was excoriated for squandering his talents. No actor ever exerted such a " +
                "profound influence on succeeding generations of actors as did Brando. More than 50" +
                " years after he first scorched the screen as Stanley Kowalski in the movie version of " +
                "Tennessee Williams' A Streetcar Named Desire (1951) and a quarter-century after his " +
                "last great performance as Col.", null));
        actors1.add(new Actor(2, "Alfredo James", "Al Patcino", new Date(1940, 4, 25),
                new City("New York", "USA"), "One of the greatest actors in all of film history, Al Pacino established himself during" +
                " one of film's greatest decades, the 1970s, and has become an enduring and iconic figure in the world of American movies." +
                " Pacino was born on April 25, 1940, in the Bronx, " +
                "New York, to an Italian-American family. His parents, Rose (Gerardi) and Salvatore Pacino. ...", null));
        actors1.add(new Actor(3, "Robert Selden", "Duvall", new Date(1931, 6, 5),
                new City("San Diego, California", "USA"), "Veteran actor and director Robert Selden Duvall " +
                "was born on January 5, 1931, in San Diego, CA, to Mildred Virginia (Hart), " +
                "an amateur actress, and William Howard Duvall, a career military officer who later " +
                "became an admiral. Duvall majored in drama at Principia College (Elsah, IL), " +
                "then served a two-year hitch in the army after graduating in 1953....", null));

        Set<Actor> actors2 = new HashSet<>();
        actors2.add(new Actor(2, "Alfredo James", "Al Patcino", new Date(1940, 4, 25),
                new City("New York", "USA"), "One of the greatest actors in all of film history, Al Pacino established himself during" +
                " one of film's greatest decades, the 1970s, and has become an enduring and iconic figure in the world of American movies." +
                " Pacino was born on April 25, 1940, in the Bronx, " +
                "New York, to an Italian-American family. His parents, Rose (Gerardi) and Salvatore Pacino. ...", null));
        actors2.add(new Actor(3, "Robert Selden", "Duvall", new Date(1931, 6, 5),
                new City("San Diego, California", "USA"), "Veteran actor and director Robert Selden Duvall " +
                "was born on January 5, 1931, in San Diego, CA, to Mildred Virginia (Hart), " +
                "an amateur actress, and William Howard Duvall, a career military officer who later " +
                "became an admiral. Duvall majored in drama at Principia College (Elsah, IL), " +
                "then served a two-year hitch in the army after graduating in 1953....", null));
        actors2.add(new Actor(4, "Robert Anthony", "De Niro Jr.", new Date(1943, 8, 17),
                new City("New York", "USA"), "Robert De Niro, thought of as one of the greatest American actors of all time," +
                " was born in New York City, to artists Virginia (Admiral) and Robert De Niro Sr. His paternal grandfather " +
                "was of Italian descent, and his other ancestry is Irish, Dutch, English, French, and German. He was trained at " +
                "the Stella Adler Conservatory and the American ...", null));

        movie1 = new Movie.Builder(1, "The Godfather")
                .director(director1)
                .genres(genres1)
                .actors(actors1).releaseDate(new Date(1972, 1 ,1))
                .story("The aging patriarch of an organized crime dynasty transfers control of his " +
                        "clandestine empire to his reluctant son.")
                .time(175).build();

        movie2 = new Movie.Builder(2, "The Godfather part II")
                .director(director1)
                .genres(genres1)
                .actors(actors2)
                .story("The early life and career of Vito Corleone in 1920s New York is portrayed while his son, Michael, " +
                        "expands and tightens his grip on his crime syndicate " +
                        "stretching from Lake Tahoe, Nevada to pre-revolution 1958 Cuba.")
                .releaseDate(new Date(1974, 1 ,1)).time(200)
                .build();
        MovieDao movieDao = new MovieDao();
        movieDao.insert(movie1);
        movieDao.insert(movie2);
    }

    @Test
    public void testInsertMovie() {
        genres.add(new Genre("Comidy"));
        Movie movie = new Movie.Builder(3, "The Dark Knight").releaseDate(new Date())
                .genres(genres).time(153).build();
        MovieDao movieDao = new MovieDao();
        movieDao.insert(movie);
    }

    @Test
    public void testFindMovie() {
        MovieDao movieDao = new MovieDao();
        Movie movie = movieDao.find(2);
        System.out.println(movie);
    }

}