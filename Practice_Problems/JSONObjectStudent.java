package json;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONObjectStudent {
    public static void main(String[] args){
        JSONArray subjects=new JSONArray();
        subjects.put("Maths");
        subjects.put("Chemistry");
        subjects.put("Computer");
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","Riya");
        jsonObject.put("age",22);
        jsonObject.put("subjects",subjects);
        System.out.println(jsonObject.toString());
    }
}
