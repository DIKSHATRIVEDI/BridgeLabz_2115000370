import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CurrencyExtractor{
    public static void extractCurrencyValues(String text){
        String regex="\\$?\\d+\\.\\d{2}";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(text);
        while(matcher.find()){
            System.out.print(matcher.group()+", ");
        }
    }
    public static void main(String[] args){
        String text="The price is $45.99, and the discount is 10.50.";
        extractCurrencyValues(text);
    }
}