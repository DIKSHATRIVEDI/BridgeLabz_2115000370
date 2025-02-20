import java.util.*;
public class FindSubsets {
    public static boolean findSubset(Set<Integer> set1, Set<Integer> set2) {
        return set2.containsAll(set1);
    }
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>(Arrays.asList(2,3));
        Set<Integer> set2=new HashSet<>(Arrays.asList(1,2,3,4));
        System.out.println(findSubset(set1, set2));
    }
}
