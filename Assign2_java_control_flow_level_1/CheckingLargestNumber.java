import java.util.Scanner;
public class CheckingLargestNumber{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter first number ");
        int number1=sc.nextInt();
        System.out.print("Enter second number ");
        int number2=sc.nextInt();
        System.out.print("Enter third number ");
        int number3=sc.nextInt();
        System.out.println("Is the first number the largest? "+(number1==Math.max(Math.max(number1,number2),number3)));
        System.out.println("Is the second number the largest? "+(number2==Math.max(Math.max(number1,number2),number3)));
        System.out.println("Is the third number the largest? "+(number3==Math.max(Math.max(number1,number2),number3)));
    }
}
