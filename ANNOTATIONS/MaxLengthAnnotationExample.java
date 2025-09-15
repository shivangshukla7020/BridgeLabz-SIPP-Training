import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(5)
    String username;

    public User(String username) throws Exception {
        Field field = this.getClass().getDeclaredField("username");
        if(field.isAnnotationPresent(MaxLength.class)) {
            MaxLength max = field.getAnnotation(MaxLength.class);
            if(username.length() > max.value()) {
                throw new IllegalArgumentException("Username too long");
            }
        }
        this.username = username;
    }
}

public class MaxLengthAnnotationExample {
    public static void main(String[] args) {
        try {
            User user = new User("admin");
            System.out.println("Username set: " + user.username);
            User user2 = new User("administrator");
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}