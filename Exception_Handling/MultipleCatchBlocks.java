import java.util.*;
public class MultipleCatchBlocks{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        try{
            System.out.print("Enter array size --> ");
            int size=sc.nextInt();
            int[] arr=new int[size];
            System.out.println("Enter array elements --> ");
            for(int i=0;i<size;i++){
                arr[i]=sc.nextInt();
            }
            System.out.print("Enter index to access --> ");
            int index=sc.nextInt();
            System.out.println("Value at index "+index+" --> "+arr[index]);
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid index!");
        }
        catch(NullPointerException e){
            System.out.println("Array is not initialized!");
        }
        catch(InputMismatchException e){
            System.out.println("Invalid input. Please enter integers only.");
        }
    }
}