import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
public class JSONRepresentation{
    public static String toJson(Object obj){
        if(obj==null){
            return "null";
        }
        StringBuilder json=new StringBuilder("{");
        Class<?> cls=obj.getClass();
        Field[] fields=cls.getDeclaredFields();
        boolean firstField=true;
        for(Field field:fields){
            field.setAccessible(true);
            try{
                Object value=field.get(obj);
                if(!firstField){
                    json.append(", ");
                }
                json.append("\"").append(field.getName()).append("\" --> ").append(formatValue(value));
                firstField=false;
            }catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }
        json.append("}");
        return json.toString();
    }
    private static String formatValue(Object value){
        if(value==null){
            return "null";
        }else if(value instanceof String){
            return "\""+value+"\"";
        }else if(value instanceof Number||value instanceof Boolean){
            return value.toString();
        }else if(value instanceof List<?>){
            return formatList((List<?>)value);
        }else if(value instanceof Map<?,?>){
            return formatMap((Map<?,?>)value);
        }else{
            return toJson(value);
        }
    }
    private static String formatList(List<?> list){
        StringBuilder json=new StringBuilder("[");
        boolean first=true;
        for(Object item:list){
            if(!first){
                json.append(", ");
            }
            json.append(formatValue(item));
            first=false;
        }
        json.append("]");
        return json.toString();
    }
    private static String formatMap(Map<?,?> map){
        StringBuilder json=new StringBuilder("{");
        boolean first=true;
        for(Map.Entry<?,?> entry:map.entrySet()){
            if(!first){
                json.append(", ");
            }
            json.append("\"").append(entry.getKey().toString()).append("\" --> ").append(formatValue(entry.getValue()));
            first=false;
        }
        json.append("}");
        return json.toString();
    }
    public static void main(String[] args){
        class Person{
            private String name;
            private int age;
            private boolean isEmployed;
            private List<String> hobbies;
            public Person(String name,int age,boolean isEmployed,List<String> hobbies){
                this.name=name;
                this.age=age;
                this.isEmployed=isEmployed;
                this.hobbies=hobbies;
            }
        }
        Person person=new Person("Riya",25,true,List.of("Reading","Hiking"));
        String json=toJson(person);
        System.out.println(json);
    }
}