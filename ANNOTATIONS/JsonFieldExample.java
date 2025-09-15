import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class User {
    @JsonField(name = "user_name")
    String username;
    
    @JsonField(name = "user_age")
    int age;

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }
}

public class JsonFieldExample {
    public static String toJson(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        Field[] fields = cls.getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            if(fields[i].isAnnotationPresent(JsonField.class)) {
                JsonField annotation = fields[i].getAnnotation(JsonField.class);
                json.append("\"").append(annotation.name()).append("\": ");
                Object value = fields[i].get(obj);
                if(value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }
                if(i < fields.length - 1) json.append(", ");
            }
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        User user = new User("Alice", 30);
        System.out.println(toJson(user));
    }
}