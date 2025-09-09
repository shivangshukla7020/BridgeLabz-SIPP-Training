import java.util.*;
import java.util.stream.*;

public class StockPriceLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(100.5, 101.2, 99.8, 102.4);

        prices.forEach(price -> System.out.println("Stock Price Update: " + price));
    }
}