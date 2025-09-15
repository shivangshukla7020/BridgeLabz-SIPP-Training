import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveOperations {
    private Map<String, Integer> cache = new HashMap<>();

    @CacheResult
    public int compute(String input) {
        if(cache.containsKey(input)) {
            System.out.println("Returning cached result for " + input);
            return cache.get(input);
        } else {
            System.out.println("Computing result for " + input);
            int result = input.length() * 42; // Simulate expensive computation
            cache.put(input, result);
            return result;
        }
    }
}

public class CacheResultExample {
    public static void main(String[] args) throws Exception {
        ExpensiveOperations ops = new ExpensiveOperations();
        Method method = ExpensiveOperations.class.getMethod("compute", String.class);
        if(method.isAnnotationPresent(CacheResult.class)) {
            System.out.println(ops.compute("abc"));
            System.out.println(ops.compute("abc"));
            System.out.println(ops.compute("xyz"));
        }
    }
}