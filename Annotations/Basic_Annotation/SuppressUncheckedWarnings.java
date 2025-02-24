import java.util.ArrayList;
public class SuppressUncheckedWarnings{
    @SuppressWarnings("unchecked")
    public static void main(String[] args){
        ArrayList list=new ArrayList();
        list.add("Cloud");
        list.add(56);
        list.add(7.14);
        String str=(String)list.get(0);
        int num=(int)list.get(1);
        double decimal=(double)list.get(2);
        System.out.println("String --> "+str);
        System.out.println("Integer --> "+num);
        System.out.println("Double --> "+decimal);
    }
}