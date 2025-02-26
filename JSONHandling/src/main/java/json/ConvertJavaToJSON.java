package json;

import com.fasterxml.jackson.databind.ObjectMapper;

class Car{
    public String model;
    Car(String model){
        this.model=model;
    }
}
public class ConvertJavaToJSON {
    public static void main(String[] args){
        try {
            ObjectMapper objectMapper=new ObjectMapper();
            Car car=new Car("Volskwagen");
            String jsonString=objectMapper.writeValueAsString(car);
            System.out.println(jsonString);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
