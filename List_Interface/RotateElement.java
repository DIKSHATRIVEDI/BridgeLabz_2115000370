import java.util.*;
public class RotateElement {
    public static <T> void rotateList(List<T> list, int pos) {
        int size = list.size();
        pos = pos % size;
        for (int i = 0; i < pos; i++) {
            T temp = list.remove(0);
            list.add(temp);
        }
        
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original List --> " + list);
        rotateList(list, 2);
        System.out.println("Rotated List --> " + list);
    }
}
