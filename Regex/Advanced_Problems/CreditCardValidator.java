import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class CreditCardValidator{
    public static boolean isValidVisa(String cardNumber){
        String regex="^4\\d{15}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(cardNumber);
        return matcher.matches();
    }
    public static boolean isValidMasterCard(String cardNumber){
        String regex="^5\\d{15}$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(cardNumber);
        return matcher.matches();
    }
    public static void main(String[] args){
        String[] cardNumbers={"4111111111111111","5105105105105100","1234567812345678","4111111111111","5999999999999999"};
        for(String card:cardNumbers){
            System.out.println(card+" is "+(isValidVisa(card)?"Valid":"Invalid")+" card.");
            System.out.println(card+" is "+(isValidMasterCard(card)?"Valid":"Invalid")+" card.");
        }
    }
}