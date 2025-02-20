import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class WordFrequencyCounter {
    public static void main(String[] args) {
        String path = "Life.txt";
        Map<String, Integer> map = countWordFrequency(path);
        System.out.println(map);
    }
    public static Map<String, Integer> countWordFrequency(String path) {
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String str;
            while ((str = br.readLine()) != null) {
                String[] words = str.toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").split("\\s+");
                for (String word : words) {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
