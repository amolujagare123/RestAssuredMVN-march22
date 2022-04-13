package PayLoad;

public class SampleRequest {


    public  static String createUserPayLoad()
    {
        return  "{\n" +
                "    \"name\": \"AMOL\",\n" +
                "    \"job\": \"Test Lead\"\n" +
                "}" ;
    }

    public  static String createUserPayLoad(String name,String job)
    {
        return  "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}" ;
    }

    public static String updateUserPayload()
    {
        return  "{\n" +
                "    \"name\": \"AMOL123\",\n" +
                "    \"job\": \"Test Lead111\"\n" +
                "}" ;
    }

    public static String updateUserPayload(String name,String job)
    {
        return  "{\n" +
                "    \"name\": \""+name+"\",\n" +
                "    \"job\": \""+job+"\"\n" +
                "}" ;
    }


}
