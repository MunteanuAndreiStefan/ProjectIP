package entitysearch;
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

public class EntitySearchApi {
    static String subscriptionKey ="55e85d3a7ee9426b8a6370109bb57235";

    static String host = "https://api.cognitive.microsoft.com";
    static String path = "/bing/v7.0/entities";

    static String mkt = "en-US";
    
    public static JSONObject entitySearchAPI(String query) throws Exception{
        String encoded_query = URLEncoder.encode (query, "UTF-8");
        String params = "?mkt=" + mkt + "&q=" + encoded_query;
        URL url = new URL (host + path + params);

        HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Ocp-Apim-Subscription-Key", subscriptionKey);
        connection.setDoOutput(true);

        StringBuilder response = new StringBuilder ();
        BufferedReader in = new BufferedReader(
        new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        in.close();
        return new JSONObject(response.toString());
    }
    
    public static JSONObject entitySearchFromText(String query) throws Exception{
        JSONObject jsonObject;
        JSONObject result=null;
        jsonObject=entitySearchAPI(query);
        if(jsonObject==null)
            return null;
        result=new JSONObject();
        int i,n;
        JSONArray objects=((JSONObject) jsonObject.get("entities")).getJSONArray("value");
        JSONObject o;
        String[] substrings=new String[]{"family","species","breed","animal","pet"};
        boolean b;
        n=objects.length();
        for(i=0;i<n;i++){
           b=false;
           o=(JSONObject)objects.get(i);
           for(String s:substrings)
               if(o.get("description").toString().contains(s))
                   b=true;
           if(o.get("name").toString().toUpperCase().equals(query.toUpperCase())&&b&&!o.has("url"))
           {
               result.put("Description",o.get("description"));
               break;
           }
        }
        return result;
    }
    /*
    public static void main(String[] args) {
        try {
            JSONObject j=entitySearchFromText("Bird");
            System.out.println(j.toString());
        } catch (Exception ex) {
            Logger.getLogger(EntitySearchApi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */
    
}
