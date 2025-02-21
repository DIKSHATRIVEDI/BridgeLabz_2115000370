import java.util.*;
public class ExceptionPropagation{
    public static double calculateInterest(double amount,double rate,int years)throws IllegalArgumentException{
        if(amount<0||rate<0){
            throw new IllegalArgumentException();
        }
        return amount*rate*years;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter amount --> ");
        double amount=sc.nextDouble();
        System.out.print("Enter rate --> ");
        double rate=sc.nextDouble();
        System.out.print("Enter years --> ");
        int years=sc.nextInt();
        try{
            double interest=calculateInterest(amount,rate,years);
            System.out.println("Calculated interest --> "+interest);
        }
        catch(IllegalArgumentException e){
            System.out.println("Invalid input --> Amount and rate must be positive");
        }
    }
}