import java.util.*;
import java.util.stream.*;

class Doctor {
    String name;
    String specialty;
    boolean availableOnWeekends;

    Doctor(String name, String specialty, boolean availableOnWeekends) {
        this.name = name;
        this.specialty = specialty;
        this.availableOnWeekends = availableOnWeekends;
    }

    @Override
    public String toString() {
        return name + " - " + specialty;
    }
}

public class DoctorAvailability {
    public static void main(String[] args) {
        List<Doctor> doctors = Arrays.asList(
            new Doctor("Dr. Smith", "Cardiology", true),
            new Doctor("Dr. Jones", "Neurology", false),
            new Doctor("Dr. Brown", "Orthopedics", true),
            new Doctor("Dr. Lee", "Dermatology", true)
        );

        doctors.stream()
            .filter(doc -> doc.availableOnWeekends)
            .sorted(Comparator.comparing(doc -> doc.specialty))
            .forEach(System.out::println);
    }
}