package img;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ImgApi
{
    private static final String uriBasePreRegion = "https://";
    private static final String uriBasePostRegion = ".api.cognitive.microsoft.com/vision/";
    private static final String uriBaseAnalyze = "v1.0/analyze";
    private static final String key = "22cfb261021343e6880a318e6c5e43ea";
    private static final String zone = "northeurope";

    public static JSONObject analyzeImage(String imageUrl) throws JSONException {
        JSONObject jsonObject;
        JSONObject result = null;
//        try
//        {
//            String content = new String(Files.readAllBytes(Paths.get("test.json")));
//            jsonObject = new JSONObject(content);
        jsonObject = analizeImageAPI(imageUrl);
        if (jsonObject == null)
            return null;
        result = new JSONObject();
        result.put("Attachement path", imageUrl);
        result.put("Class", "");
        result.put("Found concept", ((JSONObject) jsonObject.get("description")).getJSONArray("tags").get(0));
        result.append("Metadata", new JSONObject().put("Latitude", ""));
        result.append("Metadata", new JSONObject().put("Longitude", ""));
        result.put("Class matching", 0);
        result.put("Concept matching", ((JSONObject) jsonObject.getJSONArray("categories").get(0)).get("score"));
        result.append("Others matching", "");
        result.put("Text", ((JSONObject) ((JSONObject) jsonObject.get("description")).getJSONArray("captions").get(0)).get("text"));

//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
        return result;
    }

    public static JSONObject analizeImageAPI(String imageUrl)
    {
        try (CloseableHttpClient httpclient = HttpClientBuilder.create().build())
        {
            // Create the URI to access the REST API call for Analyze Image.
            String uriString = uriBasePreRegion +
                    zone +
                    uriBasePostRegion + uriBaseAnalyze;
            URIBuilder builder = new URIBuilder(uriString);

            // Request parameters. All of them are optional.
            builder.setParameter("visualFeatures", "Categories,Description,Color,Adult");
            builder.setParameter("language", "en");

            // Prepare the URI for the REST API call.
            URI uri = builder.build();
            HttpPost request = new HttpPost(uri);

            // Request headers.
            request.setHeader("Content-Type", "application/json");
            request.setHeader("Ocp-Apim-Subscription-Key", key);

            // Request body.
            StringEntity reqEntity = new StringEntity("{\"url\":\"" + imageUrl + "\"}");
            request.setEntity(reqEntity);

            // Execute the REST API call and get the response entity.
            HttpResponse response = httpclient.execute(request);
            HttpEntity entity = response.getEntity();

            // If we got a response, parse it and display it.
            if (entity != null)
            {
                // Return the JSONObject.
                String jsonString = EntityUtils.toString(entity);
                return new JSONObject(jsonString);
            } else
            {
                // No response. Return null.
                return null;
            }
        } catch (Exception e)
        {
            // An error occurred. Print error message and return null.
            System.out.println(e.getMessage());
            return null;
        }
    }
}
