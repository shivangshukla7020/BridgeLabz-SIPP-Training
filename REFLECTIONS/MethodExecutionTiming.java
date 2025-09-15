import java.lang.reflect.*;

class Task {
    public void run() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Task completed");
    }
}

public class MethodExecutionTiming {
    public static void main(String[] args) throws Exception {
        Task task = new Task();
        Method method = Task.class.getMethod("run");
        
        long start = System.nanoTime();
        method.invoke(task);
        long end = System.nanoTime();
        
        System.out.println("Execution time (ms): " + (end - start) / 1_000_000);
    }
}