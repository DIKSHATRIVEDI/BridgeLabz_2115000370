import java.lang.reflect.Field;
class Configuration{
    private static String API_KEY="initial_api_key";
    public static String getApiKey(){
        return API_KEY;
    }
    @Override
    public String toString(){
        return "Configuration(API_KEY='"+API_KEY+"')";
    }
}
public class StaticField{
    public static void main(String[] args)throws Exception{
        Class<?> cls=Configuration.class;
        Field field=cls.getDeclaredField("API_KEY");
        field.setAccessible(true);
        String currApi=(String)field.get(null);
        System.out.println("Current API Key --> "+currApi);
        String newApi="new_api_key_value";
        field.set(null,newApi);
        String updatedApi=(String)field.get(null);
        System.out.println("Updated API Key --> "+updatedApi);
        System.out.println(Configuration.getApiKey());
        Configuration config=new Configuration();
        System.out.println(config);
    }
}