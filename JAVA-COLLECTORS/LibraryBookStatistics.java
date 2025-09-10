import java.util.*;
import java.util.stream.*;

class Book {
    String genre;
    int pages;

    Book(String genre, int pages) {
        this.genre = genre;
        this.pages = pages;
    }
}

public class LibraryBookStatistics {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Fiction", 300),
            new Book("Non-Fiction", 500),
            new Book("Fiction", 250),
            new Book("Science", 400)
        );

        Map<String, IntSummaryStatistics> stats = books.stream()
            .collect(Collectors.groupingBy(b -> b.genre, Collectors.summarizingInt(b -> b.pages)));

        stats.forEach((genre, summary) -> {
            System.out.println(genre + " -> Total: " + summary.getSum() + ", Avg: " + summary.getAverage() + ", Max: " + summary.getMax());
        });
    }
}