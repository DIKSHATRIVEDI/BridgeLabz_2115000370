import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
public class FindRepeatingWords{
    public static void findRepeatingWords(String text){
        String regex="\\b(\\w+)\\b(?:\\s+\\1\\b)+";
        Pattern pattern=Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(text);
        HashSet<String> set=new HashSet<>();
        while(matcher.find()){
            set.add(matcher.group(1));
        }
        for(String word:set){
            System.out.print(word+", ");
        }
    }
    public static void main(String[] args){
        String text="This is is a repeated repeated word test.";
        findRepeatingWords(text);
    }
}