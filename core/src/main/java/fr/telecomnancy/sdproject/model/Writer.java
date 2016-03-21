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
package fr.telecomnancy.sdproject.model;

import java.util.Date;
import java.util.Set;

/**
 * @author Zakaria BENJEBARA.
 */
public class Writer extends Person {
    private Set<Movie> movies;

    public Writer(int id, String firstName, String lastName, Date birthDay,
                  City born, String biography, Set<Movie> movies) {
        super(id, firstName, lastName, birthDay, born, biography);
        this.movies = movies;
    }

    public Writer() {
        super();
    }

    public Set<Movie> getMovies() {
        return movies;
    }

}
