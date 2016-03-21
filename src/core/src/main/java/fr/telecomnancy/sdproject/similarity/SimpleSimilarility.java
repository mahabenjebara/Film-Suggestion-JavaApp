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
package fr.telecomnancy.sdproject.similarity;

import fr.telecomnancy.sdproject.model.Actor;
import fr.telecomnancy.sdproject.model.Movie;

import java.util.Set;

/**
 * @author Zakaria BENJEBARA.
 */
public class SimpleSimilarility implements MovieSimilirality {

    @Override
    public int smilarility(Movie m1, Movie m2) {

        if(m1.equals(m2))
            return 0;

        System.out.println(m1.toString());
        System.out.println(m2.toString());

        Set<Actor> actors1 = m1.getActors();
        Set<Actor> actors2 = m2.getActors();
        actors1.retainAll(actors2);

        Set<Movie.Genre> cat1 = m1.getGenres();
        Set<Movie.Genre> cat2 = m2.getGenres();
        cat1.retainAll(cat2);

        if(m1.getDirector().equals(m2.getDirector()))
            return actors1.size() + cat1.size() + 1;
        else
            return actors1.size() + cat1.size();
    }

}
