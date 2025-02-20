import java.util.*;
public class FrequencyOfElement{
    public static <T> Map<T, Integer> countFrequency(List<T> list){
        Map<T, Integer> map=new HashMap<>();
        for (T item:list){
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        return map;
    }
    public static void main(String[] args) {
        List<String> strList=Arrays.asList("apple", "banana", "apple", "orange");
        System.out.println(countFrequency(strList));
        List<Integer> intList=Arrays.asList(1, 2, 2, 3, 3, 3);
        System.out.println(countFrequency(intList));
    }
}
to