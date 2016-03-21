/*
 * Copyright (C) 2015 ZGeeks, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.telecomnancy.sdproject.utils;

import fr.telecomnancy.sdproject.model.Movie;
import fr.telecomnancy.sdproject.similarity.MovieSimilirality;
import fr.telecomnancy.sdproject.similarity.SimpleSimilarility;

import java.util.*;

/**
 * @author Zakaria BENJEBARA.
 */
public class WeightedArithmeticMean {

    private WeightedArithmeticMean() {
    }

    public static List<Movie> recommended(Set<Movie> watchedMovies, Set<Movie> movies) {

        if (watchedMovies == null || watchedMovies.isEmpty()
                || movies == null || movies.isEmpty())
            throw new IllegalArgumentException("Parameters not correctly entered !");

        System.out.println("Movies watched = "+ watchedMovies);
        System.out.println("Movies  = "+ movies);

        List<MovieScored> scores = new ArrayList<>();
        MovieSimilirality similirality = new SimpleSimilarility();
        for (Movie watched : watchedMovies) {
            for (Movie movie : movies) {
                if (watched.equals(movie))
                    continue;
                int score = similirality.smilarility(watched, movie);
                scores.add(new MovieScored(movie, score));
            }
        }

        if (scores.isEmpty())
            throw new IllegalStateException("No similiralities has found!");

        Collections.sort(scores, new Comparator<MovieScored>() {
            @Override
            public int compare(MovieScored o1, MovieScored o2) {
                return (o1.getScore() > o2.getScore()) ? 1 : (o1.getScore() == o2.getScore()) ? 0 : -1;
            }
        });

        List<Movie> result = new ArrayList<>();
        for (MovieScored score : scores) {
            result.add(score.getMovie());
        }

        return result;
    }

    public static class MovieScored {
        private final Movie movie;
        private int score;

        public MovieScored(Movie movie, int score) {
            this.movie = movie;
            this.score = score;
        }

        public Movie getMovie() {
            return movie;
        }

        public int getScore() {
            return score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            MovieScored that = (MovieScored) o;

            if (score != that.score) return false;
            if (movie != null ? !movie.equals(that.movie) : that.movie != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = movie != null ? movie.hashCode() : 0;
            result = 31 * result + score;
            return result;
        }
    }
}
