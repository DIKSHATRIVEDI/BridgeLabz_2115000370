class LegacyAPI{
    @Deprecated
    public void oldFeature(){
        System.out.println("Old feature is being used (but shouldn't be).");
    }
    public void newFeature(){
        System.out.println("New and improved feature is being used.");
    }
}
public class DeprecatedAnnotation{
    public static void main(String[] args){
        LegacyAPI api=new LegacyAPI();
        api.oldFeature();
        api.newFeature();
        @SuppressWarnings("deprecation")
        LegacyAPI api2=new LegacyAPI();
        api2.oldFeature();
    }
}