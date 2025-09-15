import java.lang.reflect.*;

class Person {
    private int age = 30;
}

public class AccessPrivateField {
    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);
        
        System.out.println("Original age: " + ageField.get(person));
        
        ageField.set(person, 40);
        
        System.out.println("Modified age: " + ageField.get(person));
    }
}