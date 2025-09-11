import java.time.LocalTime;
import java.util.*;
import java.util.stream.*;

// 1. TransportService Interface with default methods
interface TransportService {
    String getServiceName();
    double getFare();
    String getRoute();

    default void printServiceDetails() {
        System.out.println("Service: " + getServiceName() + ", Route: " + getRoute() + ", Fare: $" + getFare());
    }
}

// 2. GeoUtils with static method
interface GeoUtils {
    static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double dx = lat2 - lat1;
        double dy = lon2 - lon1;
        return Math.sqrt(dx * dx + dy * dy);
    }
}

// 3. Functional Interface
@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance);
}

// 4. Marker Interface
interface EmergencyService {
    // Marker interface for emergency services
}

// 5. BusService Implementation
class BusService implements TransportService {
    public String getServiceName() { return "City Bus"; }
    public double getFare() { return 2.5; }
    public String getRoute() { return "Route A"; }
}

// 6. MetroService Implementation
class MetroService implements TransportService {
    public String getServiceName() { return "Metro Rail"; }
    public double getFare() { return 3.0; }
    public String getRoute() { return "Route B"; }
}

// 7. TaxiService Implementation
class TaxiService implements TransportService {
    public String getServiceName() { return "Taxi"; }
    public double getFare() { return 5.0; }
    public String getRoute() { return "Route C"; }
}

// 8. AmbulanceService Implementation with Marker Interface
class AmbulanceService implements TransportService, EmergencyService {
    public String getServiceName() { return "Ambulance"; }
    public double getFare() { return 0.0; }
    public String getRoute() { return "Emergency Route"; }
}

// 9. Passenger Data Class
class Passenger {
    String name;
    String route;
    double fare;

    Passenger(String name, String route, double fare) {
        this.name = name;
        this.route = route;
        this.fare = fare;
    }
}

// 10. Schedule Data Class
class Schedule {
    TransportService service;
    LocalTime departureTime;

    Schedule(TransportService service, LocalTime departureTime) {
        this.service = service;
        this.departureTime = departureTime;
    }
}

// Main System Class
public class SmartCitySystem {
    public static void main(String[] args) {
        List<TransportService> services = Arrays.asList(
            new BusService(),
            new MetroService(),
            new TaxiService(),
            new AmbulanceService()
        );

        // Display all services using method reference
        System.out.println("=== All Services ===");
        services.forEach(TransportService::printServiceDetails);

        // Filter and sort services using lambda (earliest fare first)
        System.out.println("\n=== Filtered & Sorted Services by Fare ===");
        services.stream()
                .filter(s -> !s.getServiceName().equals("Ambulance")) // Exclude emergencies
                .sorted(Comparator.comparingDouble(TransportService::getFare))
                .forEach(TransportService::printServiceDetails);

        // Group services into emergency and non-emergency using partitioningBy
        System.out.println("\n=== Emergency vs Non-Emergency Services ===");
        Map<Boolean, List<TransportService>> grouped = services.stream()
                .collect(Collectors.partitioningBy(s -> s instanceof EmergencyService));
        grouped.get(true).forEach(s -> System.out.println("Emergency: " + s.getServiceName()));
        grouped.get(false).forEach(s -> System.out.println("Regular: " + s.getServiceName()));

        // Create schedules
        List<Schedule> schedules = Arrays.asList(
            new Schedule(new BusService(), LocalTime.of(8, 30)),
            new Schedule(new MetroService(), LocalTime.of(8, 15)),
            new Schedule(new TaxiService(), LocalTime.of(9, 00)),
            new Schedule(new AmbulanceService(), LocalTime.of(7, 45))
        );

        // Sort schedules by time using lambda
        System.out.println("\n=== Schedules Sorted by Departure Time ===");
        schedules.stream()
                 .sorted(Comparator.comparing(s -> s.departureTime))
                 .forEach(s -> System.out.println(s.departureTime + " - " + s.service.getServiceName()));

        // Revenue Report using groupingBy and summarizingDouble
        List<Passenger> passengers = Arrays.asList(
            new Passenger("Alice", "Route A", 2.5),
            new Passenger("Bob", "Route B", 3.0),
            new Passenger("Charlie", "Route A", 2.5),
            new Passenger("David", "Route C", 5.0),
            new Passenger("Eve", "Route B", 3.0)
        );

        System.out.println("\n=== Revenue Report ===");
        Map<String, Double> revenue = passengers.stream()
                .collect(Collectors.groupingBy(p -> p.route, Collectors.summingDouble(p -> p.fare)));
        revenue.forEach((route, fare) -> System.out.println(route + ": $" + fare));

        System.out.println("\n=== Passenger Stats ===");
        Map<String, DoubleSummaryStatistics> stats = passengers.stream()
                .collect(Collectors.groupingBy(p -> p.route, Collectors.summarizingDouble(p -> p.fare)));
        stats.forEach((route, summary) -> {
            System.out.println(route + " -> Total: $" + summary.getSum() +
                    ", Avg: $" + summary.getAverage() +
                    ", Max: $" + summary.getMax());
        });

        // Use functional interface FareCalculator
        FareCalculator calculator = distance -> distance * 0.5;
        double distance = GeoUtils.calculateDistance(0, 0, 3, 4);
        System.out.println("\n=== Fare Calculation ===");
        System.out.println("Distance: " + distance + " units, Fare: $" + calculator.calculateFare(distance));
    }
}
