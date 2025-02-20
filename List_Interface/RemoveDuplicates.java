import java.util.*;
public class RemoveDuplicates {
    public static <T> List<T> removeDuplicates(List<T> list){
        Set<T> set=new HashSet<>();
        List<T> ans=new ArrayList<>();
        for (T val : list){
            if (set.add(val)) ans.add(val);
        }
        return ans;
    }
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>(Arrays.asList(3, 1, 2, 2, 3, 4));
        System.out.println("Original List --> " + list);
        List<Integer> noDupli = removeDuplicates(list);
        System.out.println("List after Removing Duplicates --> " + noDupli);
    }
}
