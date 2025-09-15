import java.lang.reflect.*;
import java.util.*;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class DynamicMethodInvocation {
    public static void main(String[] args) throws Exception {
        MathOperations math = new MathOperations();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter method name (add/subtract/multiply): ");
        String methodName = scanner.nextLine();
        
        Method method = MathOperations.class.getMethod(methodName, int.class, int.class);
        int result = (int) method.invoke(math, 5, 3);
        
        System.out.println("Result: " + result);
        scanner.close();
    }
}