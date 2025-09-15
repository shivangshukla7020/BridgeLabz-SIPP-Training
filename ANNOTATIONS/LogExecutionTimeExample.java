import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class Operations {
    @LogExecutionTime
    public void task() throws InterruptedException {
        Thread.sleep(300);
        System.out.println("Task completed");
    }
}

public class LogExecutionTimeExample {
    public static void main(String[] args) throws Exception {
        Operations operations = new Operations();
        Method method = Operations.class.getMethod("task");
        if(method.isAnnotationPresent(LogExecutionTime.class)) {
            long start = System.nanoTime();
            method.invoke(operations);
            long end = System.nanoTime();
            System.out.println("Execution time (ms): " + (end - start) / 1_000_000);
        }
    }
}