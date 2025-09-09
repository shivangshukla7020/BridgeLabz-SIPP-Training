import java.util.function.Function;

public class StringLengthChecker {
    public static void main(String[] args) {
        Function<String, Integer> lengthFunc = str -> str.length();
        String message = "Hello, this is a test message.";
        System.out.println("Message length: " + lengthFunc.apply(message));
    }
}