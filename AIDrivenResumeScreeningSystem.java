import java.util.ArrayList;
import java.util.List;

abstract class JobRole {
    private String role;
    public JobRole(String role) { this.role = role; }
    public String getRole() { return role; }
}

class SoftwareEngineer extends JobRole {
    public SoftwareEngineer() { super("Software Engineer"); }
}

class DataScientist extends JobRole {
    public DataScientist() { super("Data Scientist"); }
}

class ProductManager extends JobRole {
    public ProductManager() { super("Product Manager"); }
}

class Resume<T extends JobRole> {
    private T jobRole;
    public Resume(T jobRole) { this.jobRole = jobRole; }
    public T getJobRole() { return jobRole; }
}

class ScreeningUtil {
    public static void processResumes(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            System.out.println("Screening resume for: " + role.getRole());
        }
    }
}

public class AIDrivenResumeScreeningSystem {
    public static void main(String[] args) {
        List<JobRole> roles = new ArrayList<>();
        roles.add(new SoftwareEngineer());
        roles.add(new DataScientist());
        ScreeningUtil.processResumes(roles);
    }
}