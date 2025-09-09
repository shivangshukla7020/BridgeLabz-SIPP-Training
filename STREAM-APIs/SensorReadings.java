import java.util.*;
import java.util.stream.*;

public class SensorReadings {
    public static void main(String[] args) {
        List<Double> readings = Arrays.asList(50.5, 75.2, 90.1, 65.0);
        double threshold = 70.0;

        readings.stream()
            .filter(r -> r > threshold)
            .forEach(r -> System.out.println("High reading: " + r));
    }
}