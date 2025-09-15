import java.util.*;

public class SuppressWarningsExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Test");
        list.add("Example");
        for(Object item : list) {
            System.out.println(item);
        }
    }
}