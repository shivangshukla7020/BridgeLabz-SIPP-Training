import java.util.*;

public class ListAssignments {
    // Reverse without using Collections.reverse()
    public static <T> List<T> reverseList(List<T> list) {
        List<T> reversed = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) reversed.add(list.get(i));
        return reversed;
    }

    // Frequency of elements
    public static Map<String, Integer> frequency(List<String> list) {
        Map<String, Integer> freq = new HashMap<>();
        for (String s : list) freq.put(s, freq.getOrDefault(s, 0) + 1);
        return freq;
    }

    // Rotate list by k positions
    public static <T> List<T> rotate(List<T> list, int k) {
        int n = list.size();
        k = k % n;
        List<T> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, n));
        rotated.addAll(list.subList(0, k));
        return rotated;
    }

    // Remove duplicates while preserving order
    public static <T> List<T> removeDuplicates(List<T> list) {
        Set<T> seen = new LinkedHashSet<>(list);
        return new ArrayList<>(seen);
    }

    // Find Nth element from end (LinkedList)
    public static <T> T nthFromEnd(LinkedList<T> list, int n) {
        Iterator<T> first = list.iterator();
        Iterator<T> second = list.iterator();
        for (int i = 0; i < n; i++) if (first.hasNext()) first.next();
        while (first.hasNext()) { first.next(); second.next(); }
        return second.next();
    }

    public static void main(String[] args) {
        // Test
        System.out.println(reverseList(Arrays.asList(1,2,3,4,5)));
        System.out.println(frequency(Arrays.asList("apple","banana","apple","orange")));
        System.out.println(rotate(Arrays.asList(10,20,30,40,50),2));
        System.out.println(removeDuplicates(Arrays.asList(3,1,2,2,3,4)));
        System.out.println(nthFromEnd(new LinkedList<>(Arrays.asList("A","B","C","D","E")),2));
    }
}
