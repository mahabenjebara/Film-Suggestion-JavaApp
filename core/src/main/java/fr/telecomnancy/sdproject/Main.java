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
package fr.telecomnancy.sdproject;

import fr.telecomnancy.sdproject.dao.MovieDao;
import fr.telecomnancy.sdproject.model.Movie;
import fr.telecomnancy.sdproject.utils.WeightedArithmeticMean;

import java.util.*;

/**
 * @author Zakaria BENJEBARA.
 */
public class Main {

    public static void main(String[] args) {
        MovieDao dao = new MovieDao();
        Set<Movie> movies = new HashSet<>();
        Set<Movie> moviesWatched = new HashSet<>();

        Iterator<Movie> iterator = dao.findAll().iterator();
        while (iterator.hasNext()) {
            movies.add(iterator.next());
        }

        String choice = null;
        do {
            System.out.println("Select the movie that you already watched ?");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextLine();
            switch (choice) {
                case "yes":
                    System.out.println("Enter the id of the movie that you want to set as watched ?");
                    int enter = scan.nextInt();
                    Movie movie = dao.find(enter);
                    if (movie == null) {
                        throw new RuntimeException("No movie found with the id '"+ enter+"' entered!");
                    }
                    moviesWatched.add(movie);
                    break;
                case "no":
                    break;
            }
        } while (!choice.equals("no"));
        List<Movie> movieList = WeightedArithmeticMean.recommended(moviesWatched, movies);
        System.out.println("Recommendation = "+movieList);

    }
}
