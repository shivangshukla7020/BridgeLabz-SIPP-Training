import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class Project {
    @Todo(task = "Implement login", assignedTo = "Alice")
    public void login() {}

    @Todo(task = "Write tests", assignedTo = "Bob", priority = "HIGH")
    public void tests() {}
}

public class TodoAnnotationExample {
    public static void main(String[] args) throws Exception {
        Method[] methods = Project.class.getDeclaredMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
            }
        }
    }
}