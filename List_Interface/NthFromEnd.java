import java.util.*;
public class NthFromEnd {
    static class Node<T> {
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list==null || n<=0){
            throw new IllegalArgumentException("Invalid input");
        }
        Node<T> first=new Node<>(null);
        Node<T> second=first;
        Node<T> current=first;
        for (T value : list) {
            current.next = new Node<>(value);
            current = current.next;
        }
        for (int i = 0; i < n; i++) {
            if (first.next == null) {
                throw new IllegalArgumentException("N is larger than the list size");
            }
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        return second.next.data;
    }
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;
        System.out.println(n + "th element from end --> " + findNthFromEnd(list, n));
    }
}
