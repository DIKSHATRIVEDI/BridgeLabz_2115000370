import java.util.Scanner;
public class Circle{
    double radius;
	public Circle(double radius){
	    this.radius=radius;
	}
	public double calculateArea(){
	    return Math.PI*radius*radius;
	}
	public double calculateCircumference(){
	    return 2*Math.PI*radius;
	}
	public void display(){
	    System.out.println("Radius --> "+radius);
		System.out.println("Area --> "+calculateArea());
		System.out.println("Circumference --> "+calculateCircumference());
    }
	public static void main(String[] args){
	    Scanner sc=new Scanner(System.in);
		System.out.print("Enter radius ");
		double radius=sc.nextDouble();
		Circle ob=new Circle(radius);
		ob.display();
	}
}