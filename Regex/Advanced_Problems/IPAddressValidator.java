import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class IPAddressValidator{
    public static boolean isValidIPAddress(String ipAddress){
        String regex="^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(ipAddress);
        return matcher.matches();
    }
    public static void main(String[] args){
        String[] ipAddresses={"192.168.1.1","10.0.0.1","256.1.1.1","1.1.1","1.1.1.1.1","127.0.0.1"};
        for(String ip:ipAddresses){
            System.out.println(ip+" is "+(isValidIPAddress(ip)?"a valid":"not a valid")+" IP address.");
        }
    }
}