import java.util.*;

public class SetAssignments {
    // Check if two sets are equal
    public static <T> boolean areSetsEqual(Set<T> s1, Set<T> s2) {
        return s1.equals(s2);
    }

    // Union and intersection
    public static <T> void unionIntersection(Set<T> s1, Set<T> s2) {
        Set<T> union = new HashSet<>(s1); union.addAll(s2);
        Set<T> intersection = new HashSet<>(s1); intersection.retainAll(s2);
        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }

    // Symmetric difference
    public static <T> Set<T> symmetricDifference(Set<T> s1, Set<T> s2) {
        Set<T> diff = new HashSet<>(s1); diff.addAll(s2);
        Set<T> tmp = new HashSet<>(s1); tmp.retainAll(s2);
        diff.removeAll(tmp);
        return diff;
    }

    // Convert set to sorted list
    public static List<Integer> sortedList(Set<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    // Check subset
    public static <T> boolean isSubset(Set<T> s1, Set<T> s2) {
        return s2.containsAll(s1);
    }

    public static void main(String[] args) {
        Set<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3));
        Set<Integer> s2 = new HashSet<>(Arrays.asList(3,4,5));
        System.out.println(areSetsEqual(new HashSet<>(Arrays.asList(1,2,3)), new HashSet<>(Arrays.asList(3,2,1))));
        unionIntersection(s1, s2);
        System.out.println(symmetricDifference(s1, s2));
        System.out.println(sortedList(new HashSet<>(Arrays.asList(5,3,9,1))));
        System.out.println(isSubset(new HashSet<>(Arrays.asList(2,3)), new HashSet<>(Arrays.asList(1,2,3,4))));
    }
}
