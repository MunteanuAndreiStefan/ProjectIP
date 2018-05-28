/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package img;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dodu_
 */
public class ImgApiTest {
    
    public ImgApiTest() {
    }

    /**
     * Test of analyzeImage method, of class ImgApi.
     */
    @Test
    public void testAnalyzeImage() throws Exception {
        System.out.println("analyzeImage");
        JSONParser parser = new JSONParser();
        
        Object oc = parser.parse(new FileReader("D:\\IpTestN\\ImgT.json"));
        String imageUrl = "https://www.what-dog.net/Images/faces2/scroll001.jpg";
        org.json.simple.JSONObject expResult = new org.json.simple.JSONObject();
        expResult=(org.json.simple.JSONObject)oc;
        expResult.remove("Attachement path");
       
        JSONObject result = ImgApi.analyzeImage(imageUrl);
        System.out.println(result);
        System.out.println(expResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of analizeImageAPI method, of class ImgApi.
     */
    @Test
    public void testAnalizeImageAPI() throws FileNotFoundException, IOException, ParseException, JSONException {
        System.out.println("analizeImageAPI");
        org.json.simple.JSONObject obj =  new org.json.simple.JSONObject();
        JSONParser parser = new JSONParser();
        Object oc = parser.parse(new FileReader("D:\\IpTestN\\ImgTest.json"));
        obj=(org.json.simple.JSONObject)oc;
        org.json.simple.JSONObject expResult= new org.json.simple.JSONObject();
        expResult=obj;
       String imageUrl = "https://www.what-dog.net/Images/faces2/scroll001.jpg";
        org.json.JSONObject result = ImgApi.analizeImageAPI(imageUrl);
       expResult.remove("requestId");
       expResult.put("requestId",result.get("requestId"));
       System.out.println(expResult);
       System.out.println(result);
       assertEquals(expResult, result);
        
       
    }
    
}
