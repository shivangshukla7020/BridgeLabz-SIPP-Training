import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int releaseYear;

    Movie(String title, double rating, int releaseYear) {
        this.title = title;
        this.rating = rating;
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return title + " (" + releaseYear + ") - Rating: " + rating;
    }
}

public class TopTrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 9.0, 2022),
            new Movie("Movie C", 7.8, 2021),
            new Movie("Movie D", 8.9, 2023),
            new Movie("Movie E", 9.2, 2022),
            new Movie("Movie F", 8.0, 2023)
        );

        movies.stream()
            .sorted(Comparator.comparingDouble(Movie::getRating).reversed()
                .thenComparing((m1, m2) -> Integer.compare(m2.releaseYear, m1.releaseYear)))
            .limit(5)
            .forEach(System.out::println);
    }
}