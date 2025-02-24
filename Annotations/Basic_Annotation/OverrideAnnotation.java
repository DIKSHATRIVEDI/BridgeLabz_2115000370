class Animal{
    public void makeSound(){
        System.out.println("Some generic animal sound");
    }
}
class Dog extends Animal{
    @Override
    public void makeSound(){
        System.out.println("Woof!");
    }
    public void fetch(){
        System.out.println("Dog is fetching a ball");
    }
}
public class OverrideAnnotation {
    public static void main(String[] args){
        Animal myAnimal=new Animal();
        Dog myDog=new Dog();
        myAnimal.makeSound();
        myDog.makeSound();
        myDog.fetch();
    }
}