import java.util.*;

public class EmailNotifications {
    public static void sendEmailNotification(String email) {
        System.out.println("Email sent to " + email);
    }

    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@example.com", "b@example.com");

        emails.forEach(email -> sendEmailNotification(email));
    }
}