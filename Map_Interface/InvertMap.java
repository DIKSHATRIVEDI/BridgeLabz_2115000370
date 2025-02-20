import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        Map<Integer, List<String>> invMap = invertMap(map);
        System.out.println(invMap);
    }
    public static Map<Integer, List<String>> invertMap(Map<String, Integer> map) {
        Map<Integer, List<String>> invMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            invMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }
        return invMap;
    }
}
