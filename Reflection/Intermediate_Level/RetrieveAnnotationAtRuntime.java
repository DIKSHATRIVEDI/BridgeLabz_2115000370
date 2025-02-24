import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.Annotation;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Author{
    String name();
}
@Author(name="Riya")
class Book{
    public void display(){
        System.out.println("This is a Book class");
    }
}
public class RetrieveAnnotationAtRuntime{
    public static void main(String[] args){
        Class<Book> book=Book.class;
        if(book.isAnnotationPresent(Author.class)){
            Author author=book.getAnnotation(Author.class);
            System.out.println("Author --> "+author.name());
        }
        else{
            System.out.println("No Author annotation present");
        }
    }
}