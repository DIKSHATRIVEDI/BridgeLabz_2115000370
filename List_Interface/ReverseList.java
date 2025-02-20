import java.util.*;
public class ReverseList{
    public static <T> void reverseList(List<T> list){
        int left=0, right=list.size()-1;
        while(left < right){
            T temp=list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    public static void main(String[] args){
        List<Integer> arr=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("Original Array --> "+arr);
        reverseList(arr);
        System.out.println("Reversed ArrayList --> " + arr);
        List<Integer> link=new ArrayList<>(Arrays.asList(1,2,3,4,5));
        System.out.println("\nOriginal LinkedList --> " +link);
        reverseList(link);
        System.out.println("Reversed LinkedList --> " +link);
    }
}
