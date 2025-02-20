import java.util.*;
public class IfTwoSetsAreEqual {
    public static <T> boolean EqualityOfSets(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));
        System.out.println("Are sets equal? --> " + EqualityOfSets(set1, set2));
        Set<String> set3 = new HashSet<>(Arrays.asList("apple", "banana", "orange"));
        Set<String> set4 = new HashSet<>(Arrays.asList("banana", "o" +
                "range", "apple"));
        System.out.println("Are sets equal? --> " + EqualityOfSets(set3, set4));
        Set<Integer> set5 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        System.out.println("Are sets equal? --> " + EqualityOfSets(set1, set5));
    }
}
