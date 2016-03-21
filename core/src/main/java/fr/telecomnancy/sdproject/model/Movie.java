package fr.telecomnancy.sdproject.model;

import java.util.Date;
import java.util.Set;

/**
 * @author Maha BENJEBARA.
 */
public class Movie {

    private int id;
    private String title;
    private String story;
    private Set<Genre> genres;
    private Date releaseDate;
    private int time;
    private Director director;
    private Set<Actor> actors;
    private Set<Writer> writers;

    public Movie() {
    }

    public Movie(int id, String title, String story, Set<Genre> genres, Date releaseDate,
                 int time, Director director, Set<Actor> actors, Set<Writer> writers) {
        this.id = id;
        this.title = title;
        this.story = story;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.time = time;
        this.director = director;
        this.actors = actors;
        this.writers = writers;
    }

    public Movie(Builder builder) {
        this(builder.id, builder.title, builder.story,
             builder.genres, builder.releaseDate, builder.time,
                builder.director, builder.actors, builder.writers);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getStory() {
        return story;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public int getTime() {
        return time;
    }

    public Director getDirector() {
        return director;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public Set<Writer> getWriters() {
        return writers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;

        if (id != movie.id) return false;
        if (time != movie.time) return false;
        if (releaseDate != null ? !releaseDate.equals(movie.releaseDate) : movie.releaseDate != null) return false;
        if (title != null ? !title.equals(movie.title) : movie.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (releaseDate != null ? releaseDate.hashCode() : 0);
        result = 31 * result + time;
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Movie{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", story='").append(story).append('\'');
        sb.append(", releaseDate=").append(releaseDate);
        sb.append(", time=").append(time);
        sb.append(", director=").append(director);
        sb.append(", actors=").append(actors);
        sb.append(", writers=").append(writers);
        sb.append('}');
        return sb.toString();
    }

    public static class Genre {

        private String name;

        public Genre() {
        }

        public Genre(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Genre genre = (Genre) o;

            if (name != null ? !name.equals(genre.name) : genre.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Genre{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class Builder {

        private int id;
        private String title;
        private String story;
        private Set<Genre> genres;
        private Date releaseDate;
        private int time;
        private Director director;
        private Set<Actor> actors;
        private Set<Writer> writers;

        public Builder(int id, String title) {
            this.id = id;
            this.title = title;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder story(String story) {
            this.story = story;
            return this;
        }

        public Builder genres(Set<Genre> genres) {
            this.genres = genres;
            return this;
        }

        public Builder releaseDate(Date releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder time(int time) {
            this.time = time;
            return this;
        }

        public Builder director(Director director) {
            this.director = director;
            return this;
        }

        public Builder actors(Set<Actor> actors) {
            this.actors = actors;
            return this;
        }

        public Builder writers(Set<Writer> writers) {
            this.writers = writers;
            return this;
        }

        public Movie build() {
            return new Movie(this);
        }
    }
}
