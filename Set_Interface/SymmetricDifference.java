import java.util.*;
public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result=new HashSet<>(set1);
        Set<T> temp=new HashSet<>(set2);
        result.removeAll(set2);
        temp.removeAll(set1);
        result.addAll(temp);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2=new HashSet<>(Arrays.asList(3, 4, 5));
        System.out.println("Symmetric Difference --> " + symmetricDifference(set1, set2));
        Set<String> set3=new HashSet<>(Arrays.asList("apple", "banana", "cherry"));
        Set<String> set4=new HashSet<>(Arrays.asList("banana", "cherry", "date"));
        System.out.println("Symmetric Difference --> " + symmetricDifference(set3, set4));
    }
}
