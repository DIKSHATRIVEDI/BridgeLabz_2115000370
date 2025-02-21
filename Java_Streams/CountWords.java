import java.io.*;
import java.util.*;
public class CountWords{
    public static void main(String[] args){
        String file="source.txt";
        Map<String,Integer> map=new HashMap<>();
        try(BufferedReader br=new BufferedReader(new FileReader(file))){
            String str;
            while((str=br.readLine())!=null){
                String[] words=str.toLowerCase().split("\\W+");
                for(String word:words){
                    if(!word.isEmpty()){
                        map.put(word,map.getOrDefault(word,0)+1);
                    }
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        map.entrySet().stream()
                .sorted((a,b)->b.getValue().compareTo(a.getValue()))
                .limit(5)
                .forEach(entry->System.out.println(entry.getKey()+" --> "+entry.getValue()));
    }
}