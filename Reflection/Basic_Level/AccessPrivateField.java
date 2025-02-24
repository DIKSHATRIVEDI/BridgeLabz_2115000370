import java.lang.reflect.Field;
class Person{
    private int age=15;
}
public class AccessPrivateField{
    public static void main(String[] args){
        try {
            Person person=new Person();
            Class<?> cls=person.getClass();
            Field field=cls.getDeclaredField("age");
            field.setAccessible(true);
            System.out.println("Old value --> "+field.get(person));
            field.set(person, 64);
            System.out.println("New Value --> "+field.get(person));
        }
        catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
