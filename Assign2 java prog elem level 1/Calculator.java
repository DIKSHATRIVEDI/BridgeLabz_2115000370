import java.util.Scanner;
public class Calculator{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
	System.out.println("Enter number 1");
        double number1=input.nextDouble();
	System.out.println("Enter number 2");
        double number2=input.nextDouble();
        double addition=number1+number2;
        double subtraction=number1-number2;
        double multiplication=number1*number2;
        double division=number1/number2;
        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers "+number1+" and "+number2+" is "+addition+", "+subtraction+", "+multiplication+", and "+division);
    }
}
