import java.lang.reflect.*;
import java.util.*;

class Product {
    public String name = "Laptop";
    public double price = 1200.0;
}

public class GenerateJsonRepresentation {
    public static String toJson(Object obj) throws Exception {
        Class<?> cls = obj.getClass();
        StringBuilder json = new StringBuilder("{");
        Field[] fields = cls.getDeclaredFields();
        for(int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            json.append("\"").append(fields[i].getName()).append("\": ");
            Object value = fields[i].get(obj);
            if(value instanceof String) {
                json.append("\"").append(value).append("\"");
            } else {
                json.append(value);
            }
            if(i < fields.length - 1) json.append(", ");
        }
        json.append("}");
        return json.toString();
    }

    public static void main(String[] args) throws Exception {
        Product product = new Product();
        System.out.println(toJson(product));
    }
}