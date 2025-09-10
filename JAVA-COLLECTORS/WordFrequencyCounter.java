import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "apple orange banana apple apple orange";
        String[] words = text.split("\s+");

        Map<String, Integer> frequency = Arrays.stream(words)
            .collect(Collectors.toMap(
                w -> w,
                w -> 1,
                Integer::sum
            ));

        frequency.forEach((word, count) -> System.out.println(word + ": " + count));
    }
}