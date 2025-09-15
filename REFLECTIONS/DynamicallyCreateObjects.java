import java.lang.reflect.*;

class Student {
    String name = "Default";
    int id = 0;
    
    public Student() {}
    
    @Override
    public String toString() {
        return "Student{name='" + name + "', id=" + id + "}";
    }
}

public class DynamicallyCreateObjects {
    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("Student");
        Constructor<?> constructor = studentClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Object student = constructor.newInstance();
        System.out.println(student);
    }
}